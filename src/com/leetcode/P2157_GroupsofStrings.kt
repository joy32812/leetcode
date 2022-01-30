package com.leetcode

/**
 * bitmask
 *
 * dfs-> color the graph
 */
fun groupStrings(words: Array<String>): IntArray {

    fun word2Long(s: String): Long {
        var now = 0L
        for (c in s) {
            now = now or (1L shl (c - 'a'))
        }
        return now
    }

    val nums = words.map { word2Long(it) }
    val numSet = nums.toSet()
    val countMap = nums.groupBy { it }.mapValues { it.value.size }


    val edgeMap = mutableMapOf<Long, Set<Long>>()
    for (d in numSet) {
        val set = mutableSetOf<Long>()
        ('a'..'z').forEach {
            val e = d or (1L shl (it - 'a'))
            if (e in numSet) set += e
        }


        for (i in 0 until 26) {
            if ((d and (1L shl i)) == 0L) continue
            val e = d xor (1L shl i)
            if (e in numSet) set += e
        }

        for (i in 0 until 26) {
            if ((d and (1L shl i)) == 0L) continue
            val e = d xor (1L shl i)

            for (j in 0 until 26) {
                val g = e or (1L shl j)
                if (g in numSet) set += g
            }
        }

        edgeMap[d] = set
    }


    val colorMap = mutableMapOf<Long, Int>()
    val colorNum = Array(words.size + 10) { 0 }
    var color = 0

    fun doColor(s: Long) {
        if (s in colorMap) return
        colorMap[s] = color
        colorNum[color] += countMap[s]!!

        for (t in edgeMap[s]!!) {
            doColor(t)
        }
    }


    for (s in numSet) {
        if (s in colorMap) continue
        color ++
        doColor(s)
    }

    return intArrayOf(color, colorNum.max()!!)
}

