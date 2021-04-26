package com.dardev.Data.Interface

import Music
import Musics
import io.ktor.utils.io.core.*

interface IMusicDAO:Closeable {
    fun init()
    fun getAll(): List<Musics>
    fun getById(tag:Int):Music
    fun getByTitle(titre:String):String
    fun getByArtiste(artiste: String):Music
    fun addMusic(music: Musics)
    fun updateMusic(tag: Int,music: Music):Boolean
    fun removeMusic(tag: Int):Boolean
}