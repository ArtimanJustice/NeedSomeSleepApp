package com.ariuil.lab.needsleep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ariuil.lab.needsleep.ui.navigation.MainScreenNav

import com.ariuil.lab.needsleep.ui.theme.NileRiverAdventureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NileRiverAdventureTheme {
                MainScreenNav()
            }
        }
    }
}