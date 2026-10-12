package ru.perm.v.ktor.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.perm.v.ktor.dto.ProductRepository

fun Application.configureProductRouting() {
    val repository = ProductRepository()
    routing {
        get("/product/") {
            call.respondText(repository.getAll().toString())
        }
        get("/product/{id}") {
            val paramId = call.parameters["id"]
            val id = (paramId ?: "-1").toLong()
            call.respond(repository.getById(id))
        }
    }
}
