package com.leetcode

/**
 * Greedy
 */
fun maximumSubsequenceCount(text: String, pattern: String): Long {

    val (x, y) = pattern.toCharArray()

    var total = 0L
    var xCnt = 0L
    for (ch in text) {
        if (ch == y) total += xCnt
        if (ch == x) xCnt ++
    }

    return total + Math.max(
        text.count { it == x },
        text.count { it == y }
    )
}
