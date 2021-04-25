import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*


    fun Route.playlistRouting(){
        route("/Playlist"){
            get("/playto") {
                // code to get all tickets
                call.respondText("Play Playlist!", contentType = ContentType.Text.Plain)
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
