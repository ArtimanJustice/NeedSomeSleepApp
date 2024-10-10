package com.ariuil.lab.needsleep.ui.screens.sounds.data

import com.ariuil.lab.needsleep.R

data class SoundItem(
    val name: String,
    val iconRes: Int,
    val soundRes: Int
)

val soundItems = listOf(
    SoundItem("frog", R.drawable.frog_icon, R.raw.frog_sound),
    SoundItem("bird", R.drawable.bird_icon, R.raw.bird_sound),
    SoundItem("saw", R.drawable.saw_icon, R.raw.saw_sound),
    SoundItem("rain", R.drawable.rain_icon, R.raw.rain_sound),
    SoundItem("thunder", R.drawable.thunder_icon, R.raw.thunder_sound),
    SoundItem("river", R.drawable.river_icon, R.raw.river_sound),
    SoundItem("plane", R.drawable.plane_icon, R.raw.plane_sound),
    SoundItem("car", R.drawable.car_icon, R.raw.car_sound),
    SoundItem("train", R.drawable.train_icon, R.raw.train_sound)
)
