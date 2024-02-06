package ru.perm.v.ktor

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
import junit.framework.TestCase.assertEquals
import ru.perm.v.ktor.plugins.configureRouting
import kotlin.test.Test

class RoutingTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        environment {
//            config = MapApplicationConfig(
//                "ktor.deployment.port" to "80",
//            )
//            MapApplicationConfig.
            config = MapApplicationConfig(
                "ktor.deployment.port" to "80",
            )
        }

        val response = client.get("/message")

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("MESSAGE", response.bodyAsText())
    }
}