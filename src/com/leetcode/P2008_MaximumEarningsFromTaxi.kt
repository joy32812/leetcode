package com.leetcode

/**
 * Binary index tree
 */
fun maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {

    rides.sortWith(compareBy { it[1] })
    val BIT = Array(n + 1) { 0L }

    fun update(k: Int, v: Long) {
        var x = k
        while (x <= n) {
            BIT[x] = Math.max(BIT[x], v)
            x += x and -x
        }
    }

    fun getMax(k: Int): Long {
        var x = k
        var ans = 0L
        while (x > 0) {
            ans = Math.max(ans, BIT[x])
            x -= x and -x
        }
        return ans
    }

    var ans = 0L
    for ((start, end, tip) in rides) {
        val money = tip + end - start
        val now = getMax(start) + money
        ans = Math.max(ans, now)
        update(end, now)
    }

    return ans
}

