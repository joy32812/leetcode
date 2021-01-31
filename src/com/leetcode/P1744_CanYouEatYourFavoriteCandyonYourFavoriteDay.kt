package com.leetcode

/**
 * presum + binary search
 */
fun canEat(candiesCount: IntArray, queries: Array<IntArray>): BooleanArray {

    val presum = Array(candiesCount.size) { 0L }
    for (i in candiesCount.indices) {
        presum[i] = candiesCount[i] + (if (i - 1 >= 0) presum[i - 1] else 0)
    }

    fun bs(count: Long): Int {
        if (count > presum.last()) return presum.size

        var l = 0
        var r = presum.size
        while (l < r) {
            val m = (l + r) / 2
            if (presum[m] >= count) r = m
            else l = m + 1
        }
        return l
    }

    return queries.map {
        val (type, day, cap) = it
        val minType = bs(day + 1L)
        val maxType = bs(1L * day * cap + cap)

        type in minType..maxType
    }.toBooleanArray()
}

