package com.leetcode

/**
 * easy
 */
fun countConsistentStrings(allowed: String, words: Array<String>): Int {
    return words.count { word -> word.all { it in allowed } }
}
