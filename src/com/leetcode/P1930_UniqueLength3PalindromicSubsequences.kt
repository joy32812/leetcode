package com.leetcode

/**
 * left most, right most, in between
 */
fun countPalindromicSubsequence(s: String): Int {

    fun work(ch: Char): Int {
        val first = s.indexOfFirst { it == ch }
        val last = s.indexOfLast { it == ch }
        if (first == -1 || last == -1 || first + 1 >= last) return 0

        return s.substring(first + 1 until last).toSet().size
    }

    return ('a'..'z').sumBy { work(it) }
}
