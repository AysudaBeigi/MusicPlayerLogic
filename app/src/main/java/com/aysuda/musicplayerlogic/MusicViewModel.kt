package com.aysuda.musicplayerlogic

import androidx.lifecycle.ViewModel
import java.lang.Exception

class MusicViewModel() : ViewModel() {

    //This view model is written with the idea that we cannot use the android player service
    private var currentMusic: Music? = null
    private var currentMusics: ArrayList<Music?> = arrayListOf()
    private var currentIndex: Int = 0
    private val user: User = User(UserType.normal)

    fun getCurrentPlayingMusic(): Music? {
        return currentMusic
    }

    fun getNextMusics(): List<Music?> {
        return currentMusics.slice((currentMusics.indexOf(currentMusic) + 1) until (currentMusics.size - 1))
    }

    fun pause(pauseTime: Long) {
        currentMusic?.let {
            if (it.state == MusicState.playing) {
                it.state = MusicState.paused
                it.currentTime = pauseTime
            }
        } ?: run {
            throw Exception("current music is null")
        }
    }

    fun resume(): Long {
        currentMusic?.let {
            if (it.state == MusicState.paused) {
                it.state = MusicState.playing
            }
            return it.currentTime
        } ?: run {
            throw Exception("current music is null")
        }
    }

    fun stop() {
        currentMusic?.let {
            if (it.state == MusicState.playing) {
                it.state = MusicState.stoped
                it.currentTime = 0
            }

        } ?: run {
            throw Exception("current music is null")
        }
    }

    fun play(selectedMusic: Music) {
        currentMusic = selectedMusic
        currentMusic!!.currentTime = 0
    }

    fun replaceMusics(newMusics: ArrayList<Music?>) {
        if (user.type == UserType.normal)
            if (newMusics.size < 5)
                return
            else
                shuffleMusics(musics = newMusics)

        currentMusics = newMusics
    }

    private fun shuffleMusics(musics: ArrayList<Music?>): ArrayList<Music?> {
        return musics
    }

    fun playPrevious(): Music? {
        val previousIndex = currentMusics.indexOf(currentMusic) - 1
        if (previousIndex >= 0) {
            currentMusic = currentMusics[previousIndex]
            play(currentMusic!!)
            return currentMusic
        } else {
            throw Exception("previous music is null")
        }
    }

    fun addToPlayingQueue(newMusic: Music) {
        currentMusics.add(currentIndex + 1, newMusic)
    }

    fun tryPremium() {
        //todo: must create premium account
    }
}