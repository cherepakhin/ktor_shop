package ru.perm.v.ktor.dto

import kotlin.test.assertEquals
import kotlin.test.Test

class ProductRepositoryTest {
    private val repository = ProductRepository()

    @Test
    fun `getAll should return all products`() {
        val result = repository.getAll()

        assertEquals(2, result.size)
        assertEquals(1L, result[0].id)
        assertEquals("name1", result[0].name)
    }

    @Test
    fun `getById should return product by id`() {
        val result = repository.getById(1)

        assertEquals(1L, result.id)
        assertEquals("name1", result.name)
    }

    @Test
    fun `getById should return fallback for unknown id`() {
        val result = repository.getById(99)

        assertEquals(99L, result.id)
        assertEquals("name99", result.name)
    }
}
