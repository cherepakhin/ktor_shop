package ru.perm.v.ktor.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.perm.v.ktor.dto.ProductDto
import java.lang.String.format
import java.util.logging.Logger

fun Application.configureShopRouting() {
    routing {
        get("/echo/{message}") {
            val message = call.parameters["message"]
            if (message == null || message == "") {
                Logger.getGlobal().warning("EMPTY MESSAGE")
                call.respond(HttpStatusCode(503, "ok"), "EMPTY MESSAGE")
            } else {
                Logger.getGlobal().fine(format("ECHO MESSAGE: %s", message))
                call.run { respondText(message) }
            }
        }
        get("/") {
            call.respondText("From root")
        }
    }
}
