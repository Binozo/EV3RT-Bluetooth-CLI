import events.EV3Event
import handler.ArgHandler
import handler.BluetoothHandler

fun main(args: Array<String>) {
    val argHandler = ArgHandler(args)
    argHandler.handle()
    val targetAddress = argHandler.getTargetBTAddress()

    val bluetoothHandler = BluetoothHandler(targetAddress)
    bluetoothHandler.setEventListener(object : EV3Event {
        override fun messageReceived(message: String) {
            println(message)
        }

        override fun connected() {
            println("Successfully connected to EV3")
            println("Waiting for messages...")
        }

        override fun connectionError(exception: Exception) {
            println("Connection error:")
            exception.printStackTrace()
        }

        override fun disconnected(exception: Exception?) {
            println("Disconnected")
            exception?.printStackTrace()
        }
    })
    bluetoothHandler.connect()
}