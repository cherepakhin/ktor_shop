package ru.perm.v.ktor

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class SimpleNullTest {
    private fun getNullLong(): Long? {
        return null
    }

    @Test
    fun convertNullLong() {
        val n = getNullLong()

        assertNull(n)
        assertEquals(-1L, if (n == null) -1 else n)
    }

    @Test
    fun convertNullWithElvis() {
        val n = getNullLong()

        assertNull(n)
        // Elvis operator
        val nn = n ?: -1L
        assertEquals(-1L, nn)
    }
}
