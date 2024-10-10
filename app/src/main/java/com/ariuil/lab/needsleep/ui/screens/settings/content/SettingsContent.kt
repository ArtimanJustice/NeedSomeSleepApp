package com.ariuil.lab.needsleep.ui.screens.settings.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ariuil.lab.needsleep.ui.theme.Blue
import com.ariuil.lab.needsleep.ui.theme.DarkGray
import com.ariuil.lab.needsleep.ui.theme.NewBlue
import com.ariuil.lab.needsleep.ui.theme.Rad

@Composable
fun SettingsContent(
    volume: Float,
    onVolumeChange: (Float) -> Unit,
    timerValue: Float,
    onTimerChange: (Float) -> Unit
) {
    val slideColors = SliderDefaults.colors(
        thumbColor = Color.White,
        activeTrackColor = NewBlue,
        inactiveTrackColor = DarkGray
    )

    Box(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Rad, Blue),
                    start = Offset(0f, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            VolumeControl(
                volume = volume,
                onVolumeChange = onVolumeChange,
                slideColors = slideColors
            )

            Spacer(modifier = Modifier.height(16.dp))

            TimerControl(
                timerValue = timerValue,
                onTimerChange = onTimerChange,
                slideColors = slideColors
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}