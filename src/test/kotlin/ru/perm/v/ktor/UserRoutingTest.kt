package ru.perm.v.ktor

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
import junit.framework.TestCase.assertEquals
import ru.perm.v.ktor.plugins.configureShopRouting
import ru.perm.v.ktor.plugins.configureUserRouting
import kotlin.test.Test

class UserRoutingTest {
    @Test
    fun testUrlUser() = testApplication {
        application {
            configureShopRouting()
            configureUserRouting()
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
