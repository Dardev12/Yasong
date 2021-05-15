package com.dardev

import MusicDAO
import PlaylistDAO
import UserDAO
import Configuration.Database.Manager
import Musics
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import musicRouting
import playlistRouting
import userRouting
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import io.ktor.gson.*
import io.ktor.gson.gson
import io.ktor.request.*
import io.ktor.serialization.*
import io.ktor.util.pipeline.*
import kotlinx.serialization.json.Json

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation){
        /*json(Json {
            prettyPrint = true
            isLenient = true
        })
        gson {
            setPrettyPrinting()
            disableHtmlEscaping()
            registerTypeAdapter(yourClass, GsonInstantAdapter)
        }*/

        jackson {
            registerModule(JavaTimeModule())
            enable(SerializationFeature.INDENT_OUTPUT)
            enable(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)
        }
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


