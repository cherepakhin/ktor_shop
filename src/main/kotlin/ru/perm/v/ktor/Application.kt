package ru.perm.v.ktor

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import ru.perm.v.ktor.plugins.configureRouting
import ru.perm.v.ktor.plugins.configureSerialization
import ru.perm.v.ktor.plugins.configureTemplating

fun main() {
    embeddedServer(Netty, port = 9080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureTemplating()
    configureSerialization()
    configureRouting()
}
