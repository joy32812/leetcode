package com.leetcode

/**
 * just iterate
 */
fun getMaximumGenerated(n: Int): Int {
    if (n == 0) return 0

    val data = Array(n + 1) {-1}
    data[0] = 0
    data[1] = 1

    for (i in 0 until n) {
        if (2 * i <= n) data[2 * i] = data[i]
        if (2 * i + 1 <= n) data[2 * i + 1] = data[i] + data[i + 1]
    }

    return data.max()!!
}

fun main() {
    println(getMaximumGenerated(3))
}
