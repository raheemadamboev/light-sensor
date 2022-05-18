package xyz.teamgravity.lightsensor.data

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import xyz.teamgravity.lightsensor.domain.MeasurableSensor

abstract class AndroidSensor(
    private val context: Context,
    private val feature: String,
    type: Int,
) : MeasurableSensor(type), SensorEventListener {

    override val sensorExists: Boolean
        get() = context.packageManager.hasSystemFeature(feature)

    private var manager: SensorManager? = null
    private var sensor: Sensor? = null

    override fun start() {
        if (!sensorExists) return

        initializeManager()
        initializeSensor()
        registerListener()
    }

    override fun stop() {
        if (!sensorExists) return

        unregisterListener()
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (!sensorExists) return

        if (event?.sensor?.type == type) onSensorValuesChanged?.invoke(event.values.toList())
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) = Unit

    private fun initializeManager() {
        if (manager == null) manager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    private fun initializeSensor() {
        if (sensor == null) sensor = manager?.getDefaultSensor(type)
    }

    private fun registerListener() {
        sensor?.let { manager?.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL) }
    }

    private fun unregisterListener() {
        manager?.unregisterListener(this)
    }
}