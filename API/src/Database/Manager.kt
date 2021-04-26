package com.dardev.Database

import org.jetbrains.exposed.sql.Database


class Manager{

    private val hostname="localhost"
    private val databaseName="yasong_db"
    private val userName="root"
    private val password=""

    fun initDB(): Database {
        val yaUrl="jdbc:mysql://$userName:$password@$hostname:3306/$databaseName?useUnicode=$userName&serverTimezone=UTC"
        val driver = "com.mysql.cj.jdbc.Driver"
        return Database.connect(yaUrl,driver)
    }


}