package com.dardev.Database

import org.ktorm.database.Database

class Manager{

    private val hostname="localhost"
    private val databaseName="yasong_db"
    private val userName="root"
    private val password=""

    fun initDB(){
        val yaUrl="jdbc:mysql://$userName:$password@$hostname:3306/$databaseName?useUnicode=$userName&serverTimezone=UTC"
        val driver = "com.mysql.cj.jdbc.Driver"
        Database.connect(yaUrl,driver)
    }


}