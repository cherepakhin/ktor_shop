package ru.perm.v.ktor

import org.junit.Test
import kotlin.test.assertEquals

class PairsTest {
    open class MyPairs(vararg values: kotlin.Pair<kotlin.Int, kotlin.String>) {
        open val vals = values.asList()
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

    open class InternalMyPairs() {

        open var internalMutableList = ArrayList<Pair<kotlin.Int, kotlin.String>>()
        fun putToMutableList(p2: Pair<Int, String>) {
            internalMutableList.add(p2)
        }
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

    @Test
    fun filterPairTest() {
        val pair1 = (10 to "VALUE10")
        val pair2 = (20 to "VALUE20")

        val myPairs = MyPairs(pair1, pair2, 30 to "VALUE30", 20 to "VALUE20")

        assertEquals(4, myPairs.vals.size)

        val found = myPairs.vals.filter { it.first == 10 }.toList()

        assertEquals(1, found.size)
        assertEquals((10 to "VALUE10"), found[0])
    }

    @Test
    fun mapPairTest() {
        val pair1 = (10 to "VALUE10")
        val pair2 = (20 to "VALUE20")

        val myPairs = MyPairs(pair1, pair2, 30 to "VALUE30", 20 to "VALUE20")

        val found = myPairs.vals.map { it.first }.toList()

        assertEquals(4, found.size)
        assertEquals(listOf(10, 20, 30, 20), found)
    }

    @Test
    fun calcSumPairTest() {
        val pair1 = (10 to "VALUE10")
        val pair2 = (20 to "VALUE20")

        val myPairs = MyPairs(pair1, pair2, 30 to "VALUE30", 20 to "VALUE20")

        val sum = myPairs.vals.map { it.first }.sum()

        assertEquals(80, sum)
    }

    @Test
    fun calcFilterAndSumPairTest() {
        val pair1 = (10 to "VALUE10")
        val pair2 = (20 to "VALUE20")

        val myPairs = MyPairs(pair1, pair2, 30 to "VALUE30", 20 to "VALUE20")

        val sum = myPairs.vals.filter { it.first > 20 }.map { it.first }.sum()

        assertEquals(30, sum)
    }

    @Test
    fun concatFilterAndSumPairTest() {
        val pair1 = (10 to "VALUE10")
        val pair2 = (20 to "VALUE20")

        val myPairs = MyPairs(pair1, pair2, 30 to "VALUE30", 20 to "VALUE20")

        val concatSecondsGreat10 = myPairs.vals.filter { it.first > 10 }
            .map { it.second }.joinToString("")
        assertEquals("VALUE20VALUE30VALUE20", concatSecondsGreat10)

        val resultBuilder = StringBuilder()
        myPairs.vals.filter { it.first > 10 }
            .map { it.second }.joinTo(resultBuilder,"-")
        assertEquals("VALUE20-VALUE30-VALUE20", resultBuilder.toString())
    }

    @Test
    fun concatWithResultBuilder() {
        val pair1 = (10 to "VALUE10")
        val pair2 = (20 to "VALUE20")

        val myPairs = MyPairs(pair1, pair2, 30 to "VALUE30", 20 to "VALUE20", 50 to "VALUE50")

        val resultBuilder = StringBuilder()
        myPairs.vals.filter { it.first > 20 }
            .map { it.second }.joinTo(resultBuilder,"-")

        assertEquals("VALUE30-VALUE50", resultBuilder.toString())
    }

}