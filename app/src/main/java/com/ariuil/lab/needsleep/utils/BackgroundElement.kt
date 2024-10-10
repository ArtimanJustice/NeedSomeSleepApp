package com.ariuil.lab.needsleep.utils

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

sealed class BackgroundElementColors {
    data class ColorBackground(val color: Color) : BackgroundElementColors()
    data class BrushBackground(val brush: Brush) : BackgroundElementColors()
}