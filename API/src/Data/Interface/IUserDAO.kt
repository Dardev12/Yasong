package com.dardev.Data.Interface

import User
import io.ktor.utils.io.core.*

interface IUserDAO:Closeable {
    fun init()
    fun getById(tag:Int):String
    fun getByName(name:String):String
    fun getAll():String
    fun addUser(user: User)
    fun updateUser(tag: Int,aUser : User ):Boolean
    fun removeUser(tag:Int)
}