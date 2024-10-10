package com.ariuil.lab.needsleep.ui.screens.sounds

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ariuil.lab.needsleep.ui.components.FlexibleCard
import com.ariuil.lab.needsleep.ui.previews.AllScreensPreview
import com.ariuil.lab.needsleep.ui.previews.PreviewScreen
import com.ariuil.lab.needsleep.ui.screens.sounds.data.soundItems
import com.ariuil.lab.needsleep.ui.theme.Blue
import com.ariuil.lab.needsleep.ui.theme.Rad
import com.ariuil.lab.needsleep.ui.vm.MediaPlayerViewModel
import com.ariuil.lab.needsleep.utils.BackgroundElementColors

@Composable
fun SoundsScreen(
    mediaPlayerViewModel: MediaPlayerViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.Center,
    ) {
        items(soundItems.size) { index ->
            val soundCard = soundItems[index]
            FlexibleCard(
                name = soundCard.name,
                iconRes = soundCard.iconRes,
                cardColorBack = BackgroundElementColors.BrushBackground(
                    Brush.linearGradient(
                        colors = listOf(Rad, Blue),
                        start = Offset(0f, 0f),
                        end = Offset(0f, Float.POSITIVE_INFINITY)
                    )
                ),
                onClick = { mediaPlayerViewModel.playOrStopSound(context, soundCard) }
            )
        }
    }
}

@AllScreensPreview
@Composable
fun SoundsScreenPreview() {
    PreviewScreen { mediaPlayerViewModel, modifier ->
        SoundsScreen(
            mediaPlayerViewModel = mediaPlayerViewModel,
            modifier = modifier
        )
    }
}