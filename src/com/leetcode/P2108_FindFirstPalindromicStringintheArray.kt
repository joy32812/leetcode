package com.leetcode

/**
 * easy
 */
fun firstPalindrome(words: Array<String>): String {

    return words.firstOrNull { it == it.reversed() } ?: ""

}
