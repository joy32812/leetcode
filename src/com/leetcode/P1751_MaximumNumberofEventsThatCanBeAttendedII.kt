package com.leetcode

import kotlin.math.max

/**
 * DP + binary search
 */
fun maxValue(events: Array<IntArray>, k: Int): Int {

    events.sortBy { it[0] }
    val ansMap = mutableMapOf<String, Int>()

    fun next(now: Int): Int {
        var l = now + 1
        var r = events.size
        while (l < r) {
            val m = (l + r) / 2
            if (events[m][0] > events[now][1]) r = m
            else l = m + 1
        }
        return l
    }

    fun dfs(start: Int, kk: Int): Int {
        if (start >= events.size || kk == 0) return 0

        val key = "" + start + "_" + kk
        if (key in ansMap) return ansMap[key]!!

        val ans = max(dfs(start + 1, kk), dfs(next(start), kk - 1) + events[start][2])
        ansMap[key] = ans

        return ans
    }

    return dfs(0, k)
}

fun main() {
    
}

