package com.ariuil.lab.needsleep.ui.screens.settings

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ariuil.lab.needsleep.ui.previews.AllScreensPreview
import com.ariuil.lab.needsleep.ui.previews.PreviewScreen
import com.ariuil.lab.needsleep.ui.screens.settings.content.CancelButton
import com.ariuil.lab.needsleep.ui.screens.settings.content.SettingsContent
import com.ariuil.lab.needsleep.ui.theme.DeepPurple
import com.ariuil.lab.needsleep.ui.vm.MediaPlayerViewModel

@Composable
fun SettingsScreen(
    mediaPlayerViewModel: MediaPlayerViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var volume by remember { mutableFloatStateOf(0.5f) }
    var timerValue by remember { mutableFloatStateOf(30f) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DeepPurple.copy(alpha = 0.8f)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SettingsContent(
            volume = volume,
            onVolumeChange = { newVolume ->
                volume = newVolume
                mediaPlayerViewModel.setVolume(newVolume)
            },
            timerValue = timerValue,
            onTimerChange = { newTimerValue ->
                timerValue = newTimerValue
                mediaPlayerViewModel.setTimer(newTimerValue.toInt() * 60)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CancelButton(onCancel = {
            (context as? Activity)?.finish()
        })
    }
}

@AllScreensPreview
@Composable
fun SettingsScreenPreview() {
    PreviewScreen { mediaPlayerViewModel, modifier ->
        SettingsScreen(
            mediaPlayerViewModel = mediaPlayerViewModel,
            modifier = modifier
        )
    }
}