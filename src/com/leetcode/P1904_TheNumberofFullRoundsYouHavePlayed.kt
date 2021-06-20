package com.leetcode

/**
 * easy. string time to int
 */
fun numberOfRounds(startTime: String, finishTime: String): Int {

    fun timeToInt(time: String): Int {
        val (h, m) = time.split(":").map { it.toInt() }
        return h * 60 + m
    }

    var from = timeToInt(startTime)
    var to = timeToInt(finishTime)

    if (to < from) to += 24 * 60

    from = (from / 15 + (if (from % 15 > 0) 1 else 0)) * 15
    to = (to / 15) * 15

    return (to - from) / 15
}
