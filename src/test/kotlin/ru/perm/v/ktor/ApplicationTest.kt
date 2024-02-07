package ru.perm.v.ktor

import ru.perm.v.ktor.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.*

class ApplicationTest {
//    @Test
//    fun testRoot() = testApplication {
//        application {
//            configureShopRouting()
//        }
//        client.get("/").apply {
//            assertEquals(HttpStatusCode.OK, status)
//            assertEquals("Hello World!", bodyAsText())
//        }
//    }
//    @Test
//    fun testJsonJackson() = testApplication {
//        application {
//            configureShopRouting()
//        }
//        client.get("/message").apply {
//            assertEquals(HttpStatusCode.OK, status)
//            assertEquals("MESSAGE", bodyAsText())
//        }
//    }
    @Test
    fun testEmptyUser() = testApplication {
        application {
            configureShopRouting()
        }
        client.get("/user").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Empty login", bodyAsText())
        }
    }
}
