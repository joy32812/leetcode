package com.leetcode

fun minimumBoxes(n: Int): Int {
    val dp = mutableListOf(0)
    (1..2000).forEach { dp.add(dp.last() + it * (it + 1) / 2) }

    var l = 1
    var r = 2000
    while (l < r) {
        val m = (l + r) / 2
        if (dp[m] == n) return m * (m + 1) / 2
        if (dp[m] > n) r = m
        else l = m + 1
    }
    l--

    var left = n - dp[l]
    for (i in 1 .. l + 1) {
        if (dp[i] - dp[i - 1] >= left) return l * (l + 1) / 2 + i
    }

    return 0
}

fun main() {
//    println(minimumBoxes(1))
//    println(minimumBoxes(2))
    println(minimumBoxes(3))
//    println(minimumBoxes(4))
//    println(minimumBoxes(10))
//    println(minimumBoxes(15))
}

