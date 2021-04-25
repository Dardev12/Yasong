package com.dardev.Data.Interface

import User

interface IUserDAO {
    fun getById(tag:Int):User
    fun getByName(name:String):User
    fun getAll():List<User>
    fun addUser(user: User):User
    fun updateUser(tag: Int,aUser : User ):Boolean
    fun removeUser(tag:Int):Boolean
}