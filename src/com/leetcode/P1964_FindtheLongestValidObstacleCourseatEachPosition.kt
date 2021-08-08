package com.leetcode


/**
 * Binary Index Tree: find the max/min value in a range.
 */
fun longestObstacleCourseAtEachPosition(obstacles: IntArray): IntArray {
    val toMap = obstacles.toSet().toList().sorted().mapIndexed { index, i -> i to index + 1 }.toMap()

    val n = toMap.size + 10
    val BIT = Array(n) { 0 }

    fun add(x: Int, v: Int) {
        var tx = x
        while (tx < n) {
            BIT[tx] = Math.max(BIT[tx], v)
            tx += (tx and -tx)
        }
    }

    fun get(x: Int): Int {
        var ans = 0
        var tx = x
        while (tx > 0) {
            ans = Math.max(ans, BIT[tx])
            tx -= (tx and -tx)
        }

        return ans
    }

    val ans = mutableListOf<Int>()
    for (obs in obstacles) {
        val now = toMap[obs]!!
        ans += get(now) + 1

        add(now, ans.last())
    }

    return ans.toIntArray()
}

fun main() {
    println(longestObstacleCourseAtEachPosition(
        intArrayOf(
            5,1,5,5,1,3,4,5,1,4
        )
    ))
}
