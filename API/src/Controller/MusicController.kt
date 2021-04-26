import com.dardev.Database.Manager
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.Database

fun Route.musicRouting(aMusicDAO: MusicDAO){

        route("/Music"){
            get("/play") {
                // code to get all tickets
                call.respond(mapOf("music" to aMusicDAO.getAll()))
            }
            get("/{id}") {
                // code to get a specific ticket
            }
            post("/add/{title}/{artist}") {
                // create a new ticket
                var music=call.receive<Musics>()

                aMusicDAO.addMusic(music)
                call.respond(HttpStatusCode.Created)
            }
            delete("/{id}") {
                // delete an existing ticket
            }
        }
    }

