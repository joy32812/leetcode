package com.leetcode

fun getMaximumConsecutive(coins: IntArray): Int {

    var ans = 0
    coins.sort()

    for (v in coins) {
        if (ans + 1 >= v) ans += v
        if (v > ans) break
    }

    return ans + 1
}

