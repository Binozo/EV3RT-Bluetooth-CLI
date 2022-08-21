package handler

import events.EV3Event
import java.io.IOException
import javax.microedition.io.Connector
import javax.microedition.io.StreamConnection

class BluetoothHandler(ev3BTAddress: String) {
    private var eventListener: EV3Event? = null
    private val btAddress: String = ev3BTAddress
    companion object {
        fun isValidBluetoothAddress(address: String): Boolean {
            return address.matches(Regex("^([0-9a-fA-F]{2}:){5}[0-9a-fA-F]{2}$"))
        }
    }

    private fun generateConnectionURL(address: String): String {
        // Remove all colons from the address
        val newAddress = address.replace(":".toRegex(), "")
        return "btspp://$newAddress:1;authenticate=true;encrypt=false;master=false"
    }

    fun setEventListener(listener: EV3Event) {
        eventListener = listener
    }

    fun connect() {
        println("Trying to connect to $btAddress...")
        val url = generateConnectionURL(btAddress)
        var streamConnection: StreamConnection?
        try {
            streamConnection = Connector.open(url) as StreamConnection
        } catch (e: IOException) {
            eventListener?.connectionError(e)
            return
        }
        val inputStream = streamConnection.openInputStream()
        val outputStream = streamConnection.openOutputStream()
        val reader = inputStream.bufferedReader()
        eventListener?.connected()
        try {
            while (true) {
                var line = reader.readLine()
                if (line != null) {
                    eventListener?.messageReceived(line)
                    line = reader.readLine()
                }
            }
        } catch (e: IOException) {
            eventListener?.disconnected(e)
        } finally {
            reader.close()
        }
        inputStream.close()
        outputStream.close()
        streamConnection.close()
        eventListener?.disconnected(null)
    }
}