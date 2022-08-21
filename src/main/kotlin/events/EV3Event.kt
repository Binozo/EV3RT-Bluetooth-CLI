package events

interface EV3Event {
    fun messageReceived(message: String)
    fun connected()
    fun connectionError(exception: Exception)
    fun disconnected(exception: Exception?)
}