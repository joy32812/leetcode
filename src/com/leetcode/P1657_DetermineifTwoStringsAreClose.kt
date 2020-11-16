package com.leetcode

/**
 * easy
 * kotlin == vs ===
 */
fun closeStrings(word1: String, word2: String): Boolean {
    val gp1 = word1.groupBy { it }.mapValues { entry -> entry.value.size }
    val gp2 = word2.groupBy { it }.mapValues { entry -> entry.value.size }
    return gp1.keys == gp2.keys && gp1.values.sorted() == gp2.values.sorted()
}


fun main() {
    println(closeStrings("abc", "bca"))
}

