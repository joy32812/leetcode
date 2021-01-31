package com.leetcode

/**
 * find the head
 * then find next one by one
 */
fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {

    val adjMap = mutableMapOf<Int, MutableList<Int>>()
    for (pair in adjacentPairs) {
        adjMap.getOrPut(pair[0]) { mutableListOf() } += pair[1]
        adjMap.getOrPut(pair[1]) { mutableListOf() } += pair[0]
    }

    var now = adjMap.minBy { it.value.size }!!.key
    val ans = mutableListOf(now)
    while (true) {
        var tmp = adjMap[now]!![0]
        if (ans.size > 1 && ans[ans.size - 2] == tmp) {
            if (adjMap[now]!!.size == 1) break
            tmp = adjMap[now]!![1]
        }

        ans += tmp
        now = tmp
    }
    return ans.toIntArray()
}
