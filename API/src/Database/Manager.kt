package com.dardev.Database

import org.ktorm.database.Database

class Manager{
    private val hostname="localhost"
    private val databaseName="yasong_db"
    private val userName="root"
    private val password=""

    private val yasongDatabase: Database

    init{
        val yaUrl="jdbc:mysql://$hostname:3306/$databaseName?user=$userName&password=$password&useSSL=false"
        yasongDatabase=Database.connect(yaUrl)
    }
}