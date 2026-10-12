package ru.perm.v.ktor.plugins

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.perm.v.ktor.dto.ProductDto
import java.util.logging.Logger

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    routing {
        get("/json/jackson") {
            Logger.getGlobal().info("JSON JACKSON")
            call.respond(mapOf("message" to "Jackson JSON"))
        }

        get("/json/product") {
            val product = ProductDto(1, "TestProduct")
            call.respond(product)
        }
    }
}


fun logStart() {
    println("logStart")
}