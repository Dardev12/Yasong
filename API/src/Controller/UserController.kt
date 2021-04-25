import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*


    fun Route.userRouting(){
        route("/User"){
            get("/view") {
                // code to get all tickets
                call.respondText("Hello User!", contentType = ContentType.Text.Plain)
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
