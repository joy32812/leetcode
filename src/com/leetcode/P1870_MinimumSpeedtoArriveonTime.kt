package com.leetcode

/**
 * binary search
 */
fun minSpeedOnTime(dist: IntArray, hour: Double): Int {

    val n = dist.size
    val heading = dist.toList().subList(0, n - 1)
    val minHour = 1.0 * dist[n - 1] / 1_0_000_000 + (n - 1)
    if (minHour > hour) return -1

    var l = 1
    var r = 1_0_000_000
    fun okay(speed: Int) = heading.map { Math.ceil(1.0 * it / speed) }.sum() + 1.0 * dist[n - 1] / speed <= hour

    while (l < r) {
        val m = (l + r) / 2
        if (okay(m)) r = m
        else l = m + 1
    }

    return l
}
