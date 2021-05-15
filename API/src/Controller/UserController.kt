import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.userRouting(aUserDAO: UserDAO){

        route("/User"){

            get("/view") {
                // code to get all tickets
                call.respondText(aUserDAO.getAll(),ContentType.Text.Plain)
            }
            get("/Code/{id}") {
                if(call.parameters["id"] != null)
                    call.respondText(aUserDAO.getById(call.parameters["id"]!!.toInt()),ContentType.Text.Plain)
            }
            get("/Name/{name}") {
                if(call.parameters["name"] != null)
                    call.respondText(aUserDAO.getByName(call.parameters["name"].toString()),ContentType.Text.Plain)
            }
            post("/"){

            }
            put("/"){

            }
            delete("/Supprimer/{id}") {
                if(call.parameters["id"]!=null){
                    aUserDAO.removeUser(call.parameters["id"]!!.toInt())
                    call.respond(HttpStatusCode.OK,"OK")
                }
            }
        }
}
