package com.dardev

import MusicDAO
import PlaylistDAO
import UserDAO
import Configuration.Database.Manager
import musicRouting
import playlistRouting
import userRouting

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.features.*
import io.ktor.routing.*

import io.ktor.server.engine.*
import io.ktor.server.netty.*

import io.ktor.serialization.*
import io.ktor.http.ContentType


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(DefaultHeaders)
    install(CallLogging)
    install(ContentNegotiation){
        /*
        gson {
            setPrettyPrinting()
            disableHtmlEscaping()
            registerTypeAdapter(yourClass, GsonInstantAdapter)
        }*/
        json()

//        jackson {
//            registerModule(JavaTimeModule())
//            enable(SerializationFeature.INDENT_OUTPUT)
//            enable(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)
//        }
    }
    val manager= Manager()
    val aUserDAO=UserDAO(manager.initDB())
    val aPlaylistDAO=PlaylistDAO(manager.initDB())
    val aMusicDAO=MusicDAO(manager.initDB())

    aMusicDAO.init()
    aUserDAO.init()
    aPlaylistDAO.init()

    embeddedServer(Netty, 8080) {
        routing {
            get("/") {
                call.respondText("HELLO Yasong!", contentType = ContentType.Text.Plain)
            }
            musicRouting(aMusicDAO)
            playlistRouting(aPlaylistDAO)
            userRouting(aUserDAO)
        }


    }.start(wait = true)


}


