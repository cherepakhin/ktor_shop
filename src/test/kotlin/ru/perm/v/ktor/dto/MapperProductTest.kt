package ru.perm.v.ktor.dto

import kotlin.test.assertEquals
import kotlin.test.Test

class MapperProductTest {
    private val mapper = MapperProduct()

    @Test
    fun `mapToJSON should serialize ProductDto correctly`() {
        val product = ProductDto(id = 1L, name = "TestProduct")
        val json = mapper.toJSON(product)

        assertEquals(true, json.contains("\"id\""))
        assertEquals(true, json.contains("1"))
        assertEquals(true, json.contains("\"name\""))
        assertEquals(true, json.contains("TestProduct"))
    }

    @Test
    fun `mapFromJSON should deserialize JSON correctly`() {
        val json = """{"id": 42, "name": "Widget"}"""
        val product = mapper.fromJSON(json)

        assertEquals(42L, product.id)
        assertEquals("Widget", product.name)
    }

    @Test
    fun `roundtrip should preserve data`() {
        val original = ProductDto(id = 99L, name = "Gadget")
        val json = mapper.toJSON(original)
        val restored = mapper.fromJSON(json)

        assertEquals(original.id, restored.id)
        assertEquals(original.name, restored.name)
    }
}
