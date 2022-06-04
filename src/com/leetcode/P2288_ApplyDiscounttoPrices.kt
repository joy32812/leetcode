package com.leetcode

/**
 * split -> map -> joinToString
 */
fun discountPrices(sentence: String, discount: Int): String {

    fun isPrice(s: String) = if (s.length < 2 || s[0] != '$') false else s.substring(1).all { it.isDigit() }
    fun applyDiscount(s: String) = "$%.2f".format(s.substring(1).toLong() * (100 - discount) / 100.0)

    return sentence.split(" ").map { if (isPrice(it)) applyDiscount(it) else it }.joinToString(" ")

}
