package ru.perm.v.ktor

import org.junit.Test
import kotlin.test.assertEquals

class PairsTest {
    open class MyPairs(vararg values: kotlin.Pair<kotlin.Int, kotlin.String>) {
        open var vals = values.asList()
        fun put(p2: Pair<Int, String>) {
            vals = vals.plus(p2)
        }

    }

    @Test
    fun pairTest() {
        val pair1 = (10 to "VALUE10")
        val pair2 = (20 to "VALUE20")

        val myPairs = MyPairs(pair1, pair2, 30 to "VALUE30")

        assertEquals(3, myPairs.vals.size)
        assertEquals((10 to "VALUE10"), myPairs.vals.get(0))
        assertEquals(20 to "VALUE20", myPairs.vals.get(1))
        assertEquals(30 to "VALUE30", myPairs.vals.get(2))

        val p4 = 4 to "VALUE4"
        myPairs.put(p4)
        assertEquals(4, myPairs.vals.size)
        assertEquals(p4, myPairs.vals.get(3))
    }
}