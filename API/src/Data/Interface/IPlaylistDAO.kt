package com.dardev.Data.Interface

import Playlist
import io.ktor.utils.io.core.*

interface IPlaylistDAO:Closeable {
    fun init()
    fun getById(tag : Int,tagM: Int):String
    fun getByString(title:String):String
    fun getAll():String
    fun addPlaylist(playlist: Playlist)
    fun removePlaylist(tagP: Int)
    fun removeMusicP(tagP:Int,tagM:Int)
}