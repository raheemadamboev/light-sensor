package xyz.teamgravity.lightsensor.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import xyz.teamgravity.lightsensor.presentation.screen.MainScreen
import xyz.teamgravity.lightsensor.presentation.theme.LightSensorTheme

@AndroidEntryPoint
class Main : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LightSensorTheme {
                MainScreen()
            }
        }
    }
}