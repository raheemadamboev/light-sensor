package xyz.teamgravity.lightsensor.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import xyz.teamgravity.lightsensor.R
import xyz.teamgravity.lightsensor.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(
    viewmodel: MainViewModel = hiltViewModel(),
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(if (viewmodel.dark) Color.DarkGray else Color.White)
    ) {
        Text(
            text = stringResource(id = if (viewmodel.dark) R.string.dark else R.string.light),
            color = if (viewmodel.dark) Color.White else Color.Black
        )
    }
}