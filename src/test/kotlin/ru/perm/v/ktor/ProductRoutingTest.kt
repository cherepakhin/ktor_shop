package ru.perm.v.ktor

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
import junit.framework.TestCase.assertEquals
import ru.perm.v.ktor.plugins.configureProductRouting
import ru.perm.v.ktor.plugins.configureSerialization
import ru.perm.v.ktor.plugins.configureShopRouting
import kotlin.test.Test

class ProductRoutingTest {
    @Test
    fun testProductList() = testApplication {
        application {
            configureShopRouting()
            configureSerialization()
            configureProductRouting()
        }
        environment {
            config = MapApplicationConfig(
                "ktor.deployment.port" to "8080",
            )
        }

        val response = client.get("/product/")

        assertEquals(HttpStatusCode.OK, response.status)
        val body = response.bodyAsText()
        assertEquals(true, body.contains("Product"))
        assertEquals(true, body.contains("name1"))
        assertEquals(true, body.contains("name2"))
    }

    @Test
    fun testProductById() = testApplication {
        application {
            configureShopRouting()
            configureSerialization()
            configureProductRouting()
        }
        environment {
            config = MapApplicationConfig(
                "ktor.deployment.port" to "8080",
            )
        }

        val response = client.get("/product/1")

        assertEquals(HttpStatusCode.OK, response.status)
        val body = response.bodyAsText()
        assertEquals(true, body.contains("\"id\""))
        assertEquals(true, body.contains("1"))
        assertEquals(true, body.contains("\"name\""))
        assertEquals(true, body.contains("name1"))
    }

    @Test
    fun testProductByIdNotFound() = testApplication {
        application {
            configureShopRouting()
            configureSerialization()
            configureProductRouting()
        }
        environment {
            config = MapApplicationConfig(
                "ktor.deployment.port" to "8080",
            )
        }

        val response = client.get("/product/99")

        assertEquals(HttpStatusCode.OK, response.status)
        val body = response.bodyAsText()
        assertEquals(true, body.contains("\"id\""))
        assertEquals(true, body.contains("99"))
        assertEquals(true, body.contains("name99"))
    }
}
