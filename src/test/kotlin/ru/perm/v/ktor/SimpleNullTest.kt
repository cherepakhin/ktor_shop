package ru.perm.v.ktor

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class SimpleNullTest {
    @Test
    fun convertNullLong() {
        val n = null

        assertNull(n)
        assertEquals(-1L, if (n == null) -1 else n)
        // Elvis operator
        assertEquals(-1L, n ?: -1L)
    }
}
