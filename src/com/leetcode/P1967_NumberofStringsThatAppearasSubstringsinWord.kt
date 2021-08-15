package com.leetcode

/**
 * easy
 */
fun numOfStrings(patterns: Array<String>, word: String): Int {
    return patterns.count { word.contains(it) }
}
