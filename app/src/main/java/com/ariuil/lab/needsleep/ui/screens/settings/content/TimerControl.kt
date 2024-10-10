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
fun TimerControl(
    timerValue: Float,
    onTimerChange: (Float) -> Unit,
    slideColors: SliderColors
) {
    Text(
        text = "TIMER",
        style = MaterialTheme.typography.titleMedium,
        color = Color.White
    )

    Slider(
        value = timerValue,
        onValueChange = onTimerChange,
        valueRange = 0f..60f,
        colors = slideColors,
        modifier = Modifier.fillMaxWidth(0.8f)
    )
}