package com.dardev

import MusicDAO
import UserDAO
import com.dardev.Database.Manager
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.auth.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import musicRouting
import playlistRouting
import userRouting

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val manage:Manager =  Manager()
    val musicDAO:MusicDAO=MusicDAO()
    val userDAO:UserDAO=UserDAO()
    manage.initDB()

    embeddedServer(Netty, 8080) {
        routing {
            get("/") {
                call.respondText("HELLO Yasong!", contentType = ContentType.Text.Plain)
            }
            musicRouting(musicDAO)
            playlistRouting()
            userRouting()
        }


    }.start(wait = true)


}

