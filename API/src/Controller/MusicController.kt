import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

    fun Route.musicRouting(musicDAO: MusicDAO){
        val amusicDAO=musicDAO

        route("/Music"){
            get("/play") {
                // code to get all tickets
                call.respond(amusicDAO.getAll())
            }
            get("/{id}") {
                // code to get a specific ticket
            }
            post("/") {
                // create a new ticket
            }
            delete("/{id}") {
                // delete an existing ticket
            }
        }
    }

