package ru.perm.v.ktor

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import ru.perm.v.ktor.plugins.configureSerialization
import ru.perm.v.ktor.plugins.configureShopRouting
import ru.perm.v.ktor.plugins.configureTemplating

fun main() {
    embeddedServer(Netty, port = 9080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

// not started.
//   error: Neither port nor sslPort specified. Use command line options -port/-sslPort or configure connectors in application.conf
//fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configureTemplating()
    configureSerialization()
    configureShopRouting()
}
