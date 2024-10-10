package com.ariuil.lab.needsleep.ui.vm

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ariuil.lab.needsleep.ui.screens.sounds.data.SoundItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MediaPlayerViewModel : ViewModel() {

    private var mediaPlayer: MediaPlayer? = null

    private val _currentlyPlayingItem = MutableStateFlow<SoundItem?>(null)
    val currentlyPlayingItem: StateFlow<SoundItem?> = _currentlyPlayingItem

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying

    private val _timerSecondsRemaining = MutableStateFlow(30 * 60)
    val timerSecondsRemaining: StateFlow<Int> = _timerSecondsRemaining

    private var timerJob: Job? = null

    fun playOrStopSound(context: Context, soundItem: SoundItem) {
        if (_currentlyPlayingItem.value == soundItem) {
            stopAndReleaseMediaPlayer()
            _isPlaying.value = false
            _currentlyPlayingItem.value = null
        } else {
            stopAndReleaseMediaPlayer()
            mediaPlayer = MediaPlayer.create(context, soundItem.soundRes)
            mediaPlayer?.start()
            _currentlyPlayingItem.value = soundItem
            _isPlaying.value = true
            resetTimer()
        }
    }

    fun togglePlayPause(context: Context) {
        if (_isPlaying.value) {
            pausePlaying()
        } else {
            val soundItem = _currentlyPlayingItem.value
            if (mediaPlayer == null && soundItem != null) {
                mediaPlayer = MediaPlayer.create(context, soundItem.soundRes)
            }
            mediaPlayer?.start()
            _isPlaying.value = true
            startTimer()
        }
    }

    fun setVolume(volume: Float) {
        mediaPlayer?.setVolume(volume, volume)
    }

    fun setTimer(seconds: Int) {
        _timerSecondsRemaining.value = seconds
    }

    fun pausePlaying() {
        mediaPlayer?.pause()
        _isPlaying.value = false
        pauseTimer()
    }

    fun stopPlaying() {
        stopAndReleaseMediaPlayer()
        _isPlaying.value = false
        resetTimer()
    }

    private fun stopAndReleaseMediaPlayer() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (_timerSecondsRemaining.value > 0) {
                delay(1000L)
                _timerSecondsRemaining.value -= 1
            }
            stopPlaying()
        }
    }

    private fun pauseTimer() {
        timerJob?.cancel()
    }

    private fun resetTimer() {
        _timerSecondsRemaining.value = 30 * 60
        timerJob?.cancel()
    }

    override fun onCleared() {
        super.onCleared()
        stopPlaying()
    }
}
