package com.ariuil.lab.needsleep.ui.screens.timer.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ariuil.lab.needsleep.R

@Composable
fun TimerDisplay(timerSecondsRemaining: Int, modifier: Modifier = Modifier) {
    val minutes = timerSecondsRemaining / 60
    val seconds = timerSecondsRemaining % 60
    val timeString = String.format("%02d:%02d", minutes, seconds)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.timer_back),
            contentDescription = "Timer Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = timeString,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
    }
}