package com.leetcode

/**
 * easy
 */
fun reversePrefix(word: String, ch: Char): String {
    val first = word.indexOfFirst { it == ch }
    if (first == -1) return word

    return word.substring(0..first).reversed() + word.substring(first + 1)
}
