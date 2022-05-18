package xyz.teamgravity.lightsensor.injection

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.teamgravity.lightsensor.data.LightSensor
import xyz.teamgravity.lightsensor.domain.MeasurableSensor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideMeasurableSensor(app: Application): MeasurableSensor = LightSensor(app)
}