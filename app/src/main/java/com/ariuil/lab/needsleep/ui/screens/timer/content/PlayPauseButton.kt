package com.ariuil.lab.needsleep.ui.screens.timer.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ariuil.lab.needsleep.R

@Composable
fun PlayPauseButton(
    isPlaying: Boolean,
    onTogglePlayPause: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onTogglePlayPause,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = modifier.size(180.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        val iconRes = if (isPlaying) R.drawable.pause_icon else R.drawable.start_icon

        Image(
            painter = painterResource(iconRes),
            contentDescription = if (isPlaying) "Pause Icon" else "Start Icon",
            modifier = Modifier.size(64.dp)
        )
    }
}