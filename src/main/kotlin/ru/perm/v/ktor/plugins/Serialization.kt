package ru.perm.v.ktor.plugins

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.perm.v.ktor.dto.ProductDto

fun Application.configureSerialization() {
    logStart() {
        println("Start")
    }
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
    routing {
        get("/json/jackson") {
            call.respond(mapOf("hello" to "world"))
        }
        get("/json/product") {
            call.respond(ProductDto(1L,"Name1"))
        }
    }
}

fun logStart(function: () -> Unit) {
    println("logStart")
}
