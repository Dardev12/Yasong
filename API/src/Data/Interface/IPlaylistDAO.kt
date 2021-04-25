package com.dardev.Data.Interface

import Playlist

interface IPlaylistDAO {
    fun getById(tag : Int):Playlist
    fun getByString(title:String):Playlist
    fun getAll():List<Playlist>
    fun addPlaylist(playlist: Playlist):Playlist
    fun removePlaylist(tagP: Int):Boolean
    fun removeMusicP(tagM:Int):Boolean
}