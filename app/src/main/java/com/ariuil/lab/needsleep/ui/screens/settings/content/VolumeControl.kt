package com.ariuil.lab.needsleep.ui.screens.settings.content

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun VolumeControl(
    volume: Float,
    onVolumeChange: (Float) -> Unit,
    slideColors: SliderColors
) {
    Text(
        text = "VOLUME",
        style = MaterialTheme.typography.titleMedium,
        color = Color.White
    )

    Slider(
        value = volume,
        onValueChange = onVolumeChange,
        valueRange = 0f..1f,
        colors = slideColors,
        modifier = Modifier.fillMaxWidth(0.8f)
    )
}