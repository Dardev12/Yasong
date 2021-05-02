import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.playlistRouting(aPlaylistDAO: PlaylistDAO){

        route("/Playlist"){
            get("/Collection") {
                // code to get all tickets
                call.respondText(aPlaylistDAO.getAll(), ContentType.Text.Plain)
            }
            get("/Code/{id}/{idMusic}") {
                if(call.parameters["id"]!=null && call.parameters["idMusic"]!=null)
                    call.respondText(aPlaylistDAO.getById(call.parameters["id"]!!.toInt(),call.parameters["idMusic"]!!.toInt()),ContentType.Text.Plain)
            }
            get("/Titre/{title}") {
                // code to get a specific ticket
            }
            post("/") {
                // create a new ticket
            }
            put("/"){

            }
            delete("/{id}") {
                // delete an existing ticket
            }
        }
}
