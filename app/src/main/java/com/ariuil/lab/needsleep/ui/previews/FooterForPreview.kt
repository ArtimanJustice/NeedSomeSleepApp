package com.ariuil.lab.needsleep.ui.previews

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ariuil.lab.needsleep.ui.components.NavBar
import com.ariuil.lab.needsleep.ui.navigation.data.navItems
import com.ariuil.lab.needsleep.ui.theme.NileRiverAdventureTheme
import com.ariuil.lab.needsleep.ui.vm.MediaPlayerViewModel

@Composable
fun PreviewScreen(
    content: @Composable (mediaPlayerViewModel: MediaPlayerViewModel, modifier: Modifier) -> Unit
) {
    val navController = rememberNavController()
    val mediaPlayerViewModel = MediaPlayerViewModel()

    NileRiverAdventureTheme {
        Scaffold(
            bottomBar = {
                NavBar(navController, navItems)
            }
        ) { innerPadding ->
            content(mediaPlayerViewModel, Modifier.padding(innerPadding))
        }
    }
}