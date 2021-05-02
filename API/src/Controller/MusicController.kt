import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

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
                var music= call.receive<Musics>()

                aMusicDAO.addMusic(music)
                call.respond(HttpStatusCode.Created)
            }
            put("/Modifier"){

            }
            delete("/Suprimer/{id}") {
            }
        }
    }

