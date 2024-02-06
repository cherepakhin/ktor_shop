package ru.perm.v.ktor

import org.junit.Test
import kotlin.test.assertEquals

class PairsTest {
    open class MyPairs(vararg values: kotlin.Pair<kotlin.Int, kotlin.String>) {
        open var vals = values.asList()

        //        val mutableList = MutableList<Pair<Int, String>>()
        open var internalMutableList = ArrayList<Pair<kotlin.Int, kotlin.String>>()
        fun putToInternalMutableList(p2: Pair<Int, String>) {
            vals.plus(p2)
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

        val p5 = 50 to "VALUE50"
        myPairs.putToInternalMutableList(p5)

        val pairInternalMutableList = myPairs.internalMutableList.get(0)
        assertEquals(50 to "VALUE50", pairInternalMutableList)
        assertEquals(50, pairInternalMutableList.first)
        assertEquals("VALUE50", pairInternalMutableList.second)
    }
}