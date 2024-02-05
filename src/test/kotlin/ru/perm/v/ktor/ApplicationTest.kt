package ru.perm.v.ktor

import ru.perm.v.ktor.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import ru.perm.v.ktor.plugins.configureRouting
import kotlin.test.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
    @Test
    fun testJsonJackson() = testApplication {
        application {
            configureRouting()
        }
        client.get("/message").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("MESSAGE", bodyAsText())
        }
    }
    @Test
    fun testEmptyUser() = testApplication {
        application {
            configureRouting()
        }
        client.get("/user").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Empty login", bodyAsText())
        }
    }
}
