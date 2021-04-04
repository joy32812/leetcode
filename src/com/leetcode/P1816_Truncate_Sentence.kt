package com.leetcode


/**
 * easy
 */
fun truncateSentence(s: String, k: Int): String {
    return s.split(" ").subList(0, k).joinToString(" ")
}
