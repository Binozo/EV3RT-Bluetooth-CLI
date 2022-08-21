package handler

import constants.VERSION
import kotlin.system.exitProcess

class ArgHandler(private val args: Array<String>) {
    private var targetBTAddress: String? = null

    fun handle() {
        if(args.isNotEmpty()) {
            when(args[0]) {
                "-v" -> {
                    println(VERSION)
                    exitProcess(0)
                }
                else -> {
                    // Check if the first argument is a valid Bluetooth address
                    if(BluetoothHandler.isValidBluetoothAddress(args[0])) {
                        targetBTAddress = args[0]
                    } else {
                        noValidBluetoothAddressPassed()
                    }
                }
            }
        } else {
            noValidBluetoothAddressPassed()
        }
    }

    private fun noValidBluetoothAddressPassed() {
        println("Please provide a valid Bluetooth address with the following format: XX:XX:XX:XX:XX:XX")
        exitProcess(1)
    }

    fun getTargetBTAddress(): String {
        return targetBTAddress!!
    }
}