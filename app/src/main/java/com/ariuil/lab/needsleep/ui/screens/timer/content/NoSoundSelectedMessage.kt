package com.ariuil.lab.needsleep.ui.screens.timer.content

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun NoSoundSelectedMessage(modifier: Modifier = Modifier) {
    Text(
        text = "No sound selected. Please select a sound first.",
        color = Color.White,
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier.padding(16.dp),
        textAlign = TextAlign.Center
    )
}