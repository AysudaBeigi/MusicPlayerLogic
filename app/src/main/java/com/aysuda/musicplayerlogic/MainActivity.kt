package com.aysuda.musicplayerlogic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun playingMusic():Music{
        return Music()
    }
    fun nextMusics(){

    }
    fun pause(currentTime:Double){

    }
    fun resume(){

    }
     fun stop(){

    }
    fun playPrevious(){

    }
    fun addToPlayingQueue(){

    }
    fun replaceMusics() {

    }
}