package com.leetcode

/**
 * easy
 */
fun isPrefixString(s: String, words: Array<String>): Boolean {
    return words.indices.any { words.toList().subList(0, it + 1).joinToString("") == s }
}
