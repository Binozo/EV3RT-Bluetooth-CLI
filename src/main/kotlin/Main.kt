import dev.bluefalcon.*

fun main(args: Array<String>) {
    println("Hello World!")
    val blueFalcon = BlueFalcon(ApplicationContext(), null)
    blueFalcon.delegates.add(object : BlueFalconDelegate {
        override fun didCharacteristcValueChanged(
            bluetoothPeripheral: BluetoothPeripheral,
            bluetoothCharacteristic: BluetoothCharacteristic
        ) {
            TODO("Not yet implemented")
        }

        override fun didConnect(bluetoothPeripheral: BluetoothPeripheral) {
            TODO("Not yet implemented")
        }

        override fun didDisconnect(bluetoothPeripheral: BluetoothPeripheral) {
            TODO("Not yet implemented")
        }

        override fun didDiscoverCharacteristics(bluetoothPeripheral: BluetoothPeripheral) {
            TODO("Not yet implemented")
        }

        override fun didDiscoverDevice(
            bluetoothPeripheral: BluetoothPeripheral,
            advertisementData: Map<AdvertisementDataRetrievalKeys, Any>
        ) {
            TODO("Not yet implemented")
        }

        override fun didDiscoverServices(bluetoothPeripheral: BluetoothPeripheral) {
            TODO("Not yet implemented")
        }

        override fun didReadDescriptor(
            bluetoothPeripheral: BluetoothPeripheral,
            bluetoothCharacteristicDescriptor: BluetoothCharacteristicDescriptor
        ) {
            TODO("Not yet implemented")
        }

        override fun didRssiUpdate(bluetoothPeripheral: BluetoothPeripheral) {
            TODO("Not yet implemented")
        }

        override fun didUpdateMTU(bluetoothPeripheral: BluetoothPeripheral) {
            TODO("Not yet implemented")
        }

        override fun didWriteCharacteristic(
            bluetoothPeripheral: BluetoothPeripheral,
            bluetoothCharacteristic: BluetoothCharacteristic,
            success: Boolean
        ) {
            TODO("Not yet implemented")
        }

        override fun didWriteDescriptor(
            bluetoothPeripheral: BluetoothPeripheral,
            bluetoothCharacteristicDescriptor: BluetoothCharacteristicDescriptor
        ) {
            TODO("Not yet implemented")
        }
    })

    blueFalcon.scan()
}