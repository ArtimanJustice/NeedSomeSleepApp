package com.ariuil.lab.needsleep.ui.screens.timer

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ariuil.lab.needsleep.ui.previews.AllScreensPreview
import com.ariuil.lab.needsleep.ui.previews.PreviewScreen
import com.ariuil.lab.needsleep.ui.screens.timer.content.NoSoundSelectedMessage
import com.ariuil.lab.needsleep.ui.screens.timer.content.PlayPauseButton
import com.ariuil.lab.needsleep.ui.screens.timer.content.TimerDisplay
import com.ariuil.lab.needsleep.ui.theme.DeepPurple
import com.ariuil.lab.needsleep.ui.vm.MediaPlayerViewModel

@SuppressLint("DefaultLocale")
@Composable
fun TimerScreen(
    mediaPlayerViewModel: MediaPlayerViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val isPlaying by mediaPlayerViewModel.isPlaying.collectAsState()
    val currentlyPlayingItem by mediaPlayerViewModel.currentlyPlayingItem.collectAsState()
    val timerSecondsRemaining by mediaPlayerViewModel.timerSecondsRemaining.collectAsState()

    LaunchedEffect(Unit) {
        mediaPlayerViewModel.pausePlaying()
    }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayerViewModel.stopPlaying()
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DeepPurple.copy(alpha = 0.8f)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (currentlyPlayingItem == null) {
            NoSoundSelectedMessage()
        } else {
            TimerDisplay(timerSecondsRemaining = timerSecondsRemaining)
            Spacer(modifier = Modifier.height(24.dp))
            PlayPauseButton(
                isPlaying = isPlaying,
                onTogglePlayPause = {
                    mediaPlayerViewModel.togglePlayPause(context)
                }
            )
        }
    }
}

@AllScreensPreview
@Composable
fun TimerScreenPreview() {
    PreviewScreen { mediaPlayerViewModel, modifier ->
        TimerScreen(
            mediaPlayerViewModel = mediaPlayerViewModel,
            modifier = modifier
        )
    }
}