package ru.perm.v.ktor.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.perm.v.ktor.dto.ProductDto

fun Application.configureRouting() {
    routing {
        get("/message") {
            call.respond(HttpStatusCode(200,"ok"), "MESSAGE" )
        }
        get("/") {
            call.respondText("Hello World!")
        }
        get("/user") {
            call.respondText("Empty login")
        }
        get("/user/") {
            call.respondText("Empty login/")
        }
        get("/user/{login}") {
            if (call.parameters["login"] == "")
                call.respondText("Empty login")
            else
                call.respond("Hello," + call.parameters["login"])
        }
        get("/product/{id}") {
            val paramId = call.parameters["id"]
            val id = (paramId ?: "-1").toLong()
            call.respond(ProductDto(id, "name"))
        }
    }
}
