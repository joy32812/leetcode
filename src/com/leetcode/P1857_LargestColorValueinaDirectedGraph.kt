package com.leetcode

import java.util.*

/**
 * TopSort
 */
fun largestPathValue(colors: String, edges: Array<IntArray>): Int {

    val degree = Array(colors.length) { 0 }
    val pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }
    val edgeMap = mutableMapOf<Int, MutableSet<Int>>()
    for ((s, t) in edges) {
        edgeMap.getOrPut(s) { mutableSetOf() } += t
        degree[t] ++
    }

    val nums = Array(colors.length) { Array(26) { 0 } }

    for (i in degree.indices) pq += Pair(i, degree[i])

    for (i in colors.indices) {
        if (pq.peek().second != 0) return -1

        val (x, _) = pq.poll()
        nums[x][colors[x] - 'a'] ++

        for (y in (edgeMap[x] ?: mutableSetOf())) {
            degree[y] --
            (0 until 26).forEach { nums[y][it] = Math.max(nums[y][it], nums[x][it]) }
            pq += Pair(y, degree[y])
        }
    }

    return nums.flatten().max()!!

}
