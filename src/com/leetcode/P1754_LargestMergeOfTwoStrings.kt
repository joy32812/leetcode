package com.leetcode

fun largestMerge(word1: String, word2: String): String {

    if (word1.isEmpty() || word2.isEmpty()) return word1 + word2

    if (word1 < word2) return word2[0] + largestMerge(word1, word2.substring(1))
    return word1[0] + largestMerge(word1.substring(1), word2)
}


fun main() {
    println(largestMerge("cabaa", "bcaaa"))
}

