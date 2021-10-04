package com.leetcode

/**
 * greedy
 */
fun minimumMoves(s: String): Int {
    val first = s.indexOfFirst { it == 'X' }
    if (first == -1) return 0
    if (first + 3 >= s.length) return 1

    return 1 + minimumMoves(s.substring(first + 3))
}
