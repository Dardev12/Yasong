package com.dardev.Data.Interface

import Music

interface IMusicDAO {
    fun getAll():List<Music>
    fun getById(tag:Int):Music
    fun getByTitle(titre:String):Music
    fun getByArtiste(artiste: String):Music
    fun addMusic(music: Music):Music
    fun updateMusic(tag: Int,music: Music):Boolean
    fun removeMusic(tag: Int):Boolean
}