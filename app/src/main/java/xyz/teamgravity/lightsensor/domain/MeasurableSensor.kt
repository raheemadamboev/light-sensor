package xyz.teamgravity.lightsensor.domain

abstract class MeasurableSensor(
    protected val type: Int,
) {

    protected var onSensorValuesChanged: ((List<Float>) -> Unit)? = null

    abstract val sensorExists: Boolean

    abstract fun start()
    abstract fun stop()

    @JvmName("setOnSensorValuesChangedListener")
    fun setOnSensorValuesChanged(onSensorValuesChanged: (List<Float>) -> Unit) {
        this.onSensorValuesChanged = onSensorValuesChanged
    }
}