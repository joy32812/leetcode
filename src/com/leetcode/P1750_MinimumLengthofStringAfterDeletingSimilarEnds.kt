package com.leetcode

/**
 * easy, two points
 */
fun minimumLength(s: String): Int {

    fun work(i: Int, j: Int): Int {
        if (i > j) return 0
        if (i == j) return 1
        if (s[i] != s[j]) return j - i + 1

        var from = i
        while (from <= j && s[from] == s[i]) from ++

        var to = j
        while (to >= i && s[to] == s[i]) to --

        return work(from, to)
    }

    return work(0, s.length - 1)
}


