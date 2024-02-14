package ru.perm.v.ktor

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
import junit.framework.TestCase.assertEquals
import ru.perm.v.ktor.plugins.configureShopRouting
import kotlin.test.Test

class RoutingTest {
    @Test
    fun testUrlEcho() = testApplication {
        application {
            configureShopRouting()
        }
        environment {
            config = MapApplicationConfig(
                "ktor.deployment.port" to "8080",
            )
        }

        val response = client.get("/echo/MESSAGE")

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("MESSAGE", response.bodyAsText())
    }

    @Test
    fun testRoot() = testApplication {
        application {
            configureShopRouting()
        }
        environment {
            config = MapApplicationConfig(
                "ktor.deployment.port" to "8080",
            )
        }

        val response = client.get("/")

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("From root", response.bodyAsText())
    }

    @Test
    fun testUrlUser() = testApplication {
        application {
            configureShopRouting()
        }
        environment {
            config = MapApplicationConfig(
                "ktor.deployment.port" to "8080",
            )
        }

        val response = client.get("/user")

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Empty login", response.bodyAsText())
    }
}