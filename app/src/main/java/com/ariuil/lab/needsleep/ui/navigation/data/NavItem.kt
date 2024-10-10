package com.ariuil.lab.needsleep.ui.navigation.data

import com.ariuil.lab.needsleep.R
import com.ariuil.lab.needsleep.ui.navigation.data.NavRoutes.SETTINGS_SCREEN
import com.ariuil.lab.needsleep.ui.navigation.data.NavRoutes.SOUNDS_SCREEN
import com.ariuil.lab.needsleep.ui.navigation.data.NavRoutes.TIMER_SCREEN

data class NavItem(
    val route: String,
    val icon: Int,
    val contentDescription: String
)

val navItems = listOf(
    NavItem(SOUNDS_SCREEN, R.drawable.sounds_icon, "Sounds Screen"),
    NavItem(TIMER_SCREEN, R.drawable.timer_icon, "Timer Screen"),
    NavItem(SETTINGS_SCREEN, R.drawable.settings_icon, "Settings Screen")
)