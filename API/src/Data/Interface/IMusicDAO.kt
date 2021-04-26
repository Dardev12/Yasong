package com.dardev.Data.Interface

import Music
import Musics

interface IMusicDAO {
    fun getAll(): ArrayList<Musics>
    fun getById(tag:Int):Music
    fun getByTitle(titre:String):String
    fun getByArtiste(artiste: String):Music
    fun addMusic(music: Music):Music
    fun updateMusic(tag: Int,music: Music):Boolean
    fun removeMusic(tag: Int):Boolean
}