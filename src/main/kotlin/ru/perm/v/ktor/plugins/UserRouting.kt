package ru.perm.v.ktor.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureUserRouting() {
    routing {
        get("/user") {
            call.respondText("Empty login")
        }
        get("/user/") {
            call.respondText("Empty login/")
        }
        get("/user/{login}") {
            val login = call.parameters["login"]
            if (login == "") {
                call.respondText("Empty login")
            } else {
                call.respond("Hello, $login")
            }
        }
    }
}
