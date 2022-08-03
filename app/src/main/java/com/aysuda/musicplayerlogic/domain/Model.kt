package com.aysuda.musicplayerlogic.domain

data class Music(
    var currentTime: Long,
    var state: MusicState,
    val time:Long,
    val album: String,
    val name: String,
    val singer: String,
    val coverUrl: String

)
enum class MusicState{
    playing,paused,stoped,resumed
}
data class User(
    val type: UserType
)
enum class UserType {
    normal, premuim
}