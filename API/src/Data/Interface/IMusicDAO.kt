package com.dardev.Data.Interface

import Music
import Musics
import io.ktor.utils.io.core.*

interface IMusicDAO:Closeable {
    fun init()
    fun getAll(): String
    fun getById(tag:Int):String
    fun getByTitle(titre:String):String
    fun getByArtiste(artiste: String):String
    fun addMusic(music: Musics)
    fun updateMusic(tag: Int,music: Musics)
    fun removeMusic(tag: Int)
}