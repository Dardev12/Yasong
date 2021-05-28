
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*

fun Route.musicRouting(aMusicDAO: MusicDAO){

        route("/Music"){

            get("/Bibliothèque") {
                call.respondText(aMusicDAO.getAll(),ContentType.Text.Plain)
            }
            get("/Tag/{id}") {
                if(call.parameters["id"] != null)
                    call.respondText(aMusicDAO.getById(call.parameters["id"]!!.toInt()),ContentType.Text.Plain)
            }
            get("/Titre/{name}"){
                if(call.parameters["name"]!=null)
                    call.respondText(aMusicDAO.getByTitle(call.parameters["name"].toString()),ContentType.Text.Plain)
            }
            get("/Artiste/{name}"){
                if(call.parameters["name"]!=null)
                    call.respondText(aMusicDAO.getByArtiste(call.parameters["name"].toString()),ContentType.Text.Plain)
            }

            post("/Add") {

                    //val post = call.receive<Musics>()
                    val post = Musics(null,"Testya","TEXTO","3min",2)

                    /*val obj=call.receive<JsonObject>()
                    val test = Json.encodeToString(obj)
                    val data=Json.decodeFromString<Musics>(test)*/

                    //val music = call.receiveParameters()
                    //val obj=Musics(null,music["title"],music["artist"],music["duration"], music["tagU"]?.toInt())
                    //val obj=Json.decodeFromString<Musics>(music.toString())
                    aMusicDAO.addMusic(post)
                    call.respondText("It's work",ContentType.Text.Plain)

                    //call.respond()
                    //call.respond(HttpStatusCode.Created,)

            }
            put("/Modifier/{id}"){

                //val music = call.receive<Musics>()
                //call.respondText(music.toString(),ContentType.Text.Plain)

                val put = Musics(null,"Cry","Big Life","3min",2)
                if(call.parameters["id"]!= null && put != null )
                    aMusicDAO.updateMusic(call.parameters["id"]!!.toInt(),put)

                call.respondText("It's work",ContentType.Text.Plain)
            }
            delete("/Supprimer/{id}") {

                if(call.parameters["id"]!=null){
                    aMusicDAO.removeMusic(call.parameters["id"]!!.toInt())
                    call.respond(HttpStatusCode.OK,"OK")
                }

            }
        }
    }


