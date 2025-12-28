//Routing.kt
package com.nexus.ktor.lancorC.lancorC

import com.nexus.ktor.auth.authRoutes
import io.ktor.server.application.*
import io.ktor.server.response.*
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
