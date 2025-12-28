//Routing.kt
package lancorC

import lancorC.auth.authRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*

//fun Application.configureRouting() {
//    routing {
//        get("/") {
//            call.respondText("Hello World!")
//        }
//    }
//}

fun Application.configureRouting() {
    routing {
        authRoutes()
    }
}
