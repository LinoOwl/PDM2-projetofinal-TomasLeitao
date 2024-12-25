package com.tomaspdm2

import com.tomaspdm2.routes.productRoutes
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        productRoutes()
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
