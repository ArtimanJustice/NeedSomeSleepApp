package com.ariuil.lab.needsleep.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ariuil.lab.needsleep.ui.components.NavBar
import com.ariuil.lab.needsleep.ui.navigation.data.NavRoutes.SETTINGS_SCREEN
import com.ariuil.lab.needsleep.ui.navigation.data.NavRoutes.SOUNDS_SCREEN
import com.ariuil.lab.needsleep.ui.navigation.data.NavRoutes.TIMER_SCREEN
import com.ariuil.lab.needsleep.ui.navigation.data.navItems
import com.ariuil.lab.needsleep.ui.screens.settings.SettingsScreen
import com.ariuil.lab.needsleep.ui.screens.sounds.SoundsScreen
import com.ariuil.lab.needsleep.ui.screens.timer.TimerScreen
import com.ariuil.lab.needsleep.ui.vm.MediaPlayerViewModel

@Composable
fun MainScreenNav() {
    val navController = rememberNavController()
    val mediaPlayerViewModel: MediaPlayerViewModel = viewModel()

    Scaffold(
        bottomBar = {
            NavBar(navController, navItems)
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = SOUNDS_SCREEN,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(SOUNDS_SCREEN) {
                SoundsScreen(mediaPlayerViewModel = mediaPlayerViewModel)
            }
            composable(TIMER_SCREEN) {
                TimerScreen(mediaPlayerViewModel = mediaPlayerViewModel)
            }
            composable(SETTINGS_SCREEN) {
                SettingsScreen(mediaPlayerViewModel = mediaPlayerViewModel)
            }
        }
    }
}