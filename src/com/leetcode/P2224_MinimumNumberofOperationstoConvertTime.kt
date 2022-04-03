package com.leetcode

/**
 * Greedy
 */
fun convertTime(current: String, correct: String): Int {

    fun String.toIntTime(): Int {
        val (h, m) = split(":").map { it.toInt() }
        return h * 60 + m
    }

    var ans = 0
    var now = current.toIntTime()
    val target = correct.toIntTime()

    val options = listOf(60, 15, 5, 1)

    while (now != target) {
        val opt = options.first { now + it <= target }
        ans ++
        now += opt
    }

    return ans
}
