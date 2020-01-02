package com.leetcode


fun sumZero(n: Int): IntArray {
    var ans = (1..n/2).map { listOf(-it, it)}.flatMap { it.toList() }
    if (n % 2 == 1) ans += 0
    return ans.toIntArray()
}
