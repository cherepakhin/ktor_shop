package ru.perm.v.ktor

import org.junit.Test
import kotlin.test.assertEquals

class PairsTest {
    open class MyPairs(vararg values: kotlin.Pair<kotlin.Int, kotlin.String>) {
        open val vals = values.asList()
    }

    open class InternalMyPairs() {

        open var internalMutableList = ArrayList<Pair<kotlin.Int, kotlin.String>>()
        fun putToMutableList(p2: Pair<Int, String>) {
            internalMutableList.add(p2)
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

    }

    @Test
    fun putPair() {
        val myPairs = InternalMyPairs()
        val p5 = 50 to "VALUE50"
        myPairs.putToMutableList(p5)

        val pair0FromInternalMutableList = myPairs.internalMutableList.get(0)
        assertEquals(50 to "VALUE50", pair0FromInternalMutableList)
        assertEquals(50, pair0FromInternalMutableList.first)
        assertEquals("VALUE50", pair0FromInternalMutableList.second)
    }
}