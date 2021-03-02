package com.leetcode

fun minOperations(n: Int): Int {

    var l = 1
    var r = 2 * n - 1

    var ans = 0
    while (l < r) {
        ans += (l + r) / 2 - l
        l += 2
        r -= 2
    }

    return ans
}
