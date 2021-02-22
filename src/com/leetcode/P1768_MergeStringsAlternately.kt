package com.leetcode

fun mergeAlternately(word1: String, word2: String): String {
    if (word1.isEmpty() || word2.isEmpty()) return word1 + word2
    return "" + word1[0] + word2[0] + mergeAlternately(word1.substring(1), word2.substring(1))
}
