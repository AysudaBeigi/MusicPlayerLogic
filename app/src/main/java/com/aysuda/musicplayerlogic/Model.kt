package com.aysuda.musicplayerlogic

data class Music(
    val currentTime: Double,
    val album: String,
    val name: String,
    val singer: String,
    val coverUrl: String

)

enum class User {
    normal, premuim
}