package ru.perm.v.ktor

import io.ktor.server.application.*
import ru.perm.v.ktor.plugins.configureSerialization
import ru.perm.v.ktor.plugins.configureShopRouting
import ru.perm.v.ktor.plugins.configureTemplating

//fun main() {
//    embeddedServer(Netty, port = 9080, host = "0.0.0.0", module = Application::module)
//        .start(wait = true)
//}

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configureTemplating()
    configureSerialization()
    configureShopRouting()
}
