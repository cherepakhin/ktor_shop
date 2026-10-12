package ru.perm.v.ktor.dto

import kotlin.test.assertEquals
import kotlin.test.Test

class MapperProductTest {

    @Test
    fun `mapToJSON should serialize ProductDto correctly`() {
        val product = ProductDto(id = 1L, name = "TestProduct")
        val json = MapperProduct.toJSON(product)

        assertEquals(true, json.contains("\"id\""))
        assertEquals(true, json.contains("1"))
        assertEquals(true, json.contains("\"name\""))
        assertEquals(true, json.contains("TestProduct"))
    }

    @Test
    fun `mapFromJSON should deserialize JSON correctly`() {
        val json = """{"id": 42, "name": "Widget"}"""
        val product = MapperProduct.fromJSON(json)

        assertEquals(42L, product.id)
        assertEquals("Widget", product.name)
    }

    @Test
    fun `roundtrip should preserve data`() {
        val original = ProductDto(id = 99L, name = "Gadget")
        val json = MapperProduct.toJSON(original)
        val restored = MapperProduct.fromJSON(json)

        assertEquals(original.id, restored.id)
        assertEquals(original.name, restored.name)
    }
}
