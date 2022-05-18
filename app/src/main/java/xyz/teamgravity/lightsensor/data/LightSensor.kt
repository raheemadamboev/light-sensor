package xyz.teamgravity.lightsensor.data

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor

class LightSensor(
    context: Context,
) : AndroidSensor(
    context = context,
    feature = PackageManager.FEATURE_SENSOR_LIGHT,
    type = Sensor.TYPE_LIGHT
)