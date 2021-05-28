package com.dardev.Data.Interface

import User
import Users
import io.ktor.utils.io.core.*

interface IUserDAO:Closeable {
    fun init()
    fun getById(tag:Int):String
    fun getByName(name:String):String
    fun getAll():String
    fun addUser(user: Users)
    fun updateUser(tag: Int,aUser : Users )
    fun removeUser(tag:Int)
}