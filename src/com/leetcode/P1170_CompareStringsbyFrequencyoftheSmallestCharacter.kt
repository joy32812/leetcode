package com.leetcode


fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
    fun numOfSmall(s: String): Int = s.groupBy { it }.minBy { it.key }!!.value.size

    val cntMap = mutableMapOf<Int, Int>()
    words.forEach {
        val num = numOfSmall(it)
        cntMap[num] = (cntMap[num] ?: 0) + 1
    }


    fun myCount(s: String): Int{
        val num = numOfSmall(s)
        return (num+1..11).sumBy { cntMap[it] ?: 0}
    }

    return queries.map { myCount(it) }.toIntArray()

}

