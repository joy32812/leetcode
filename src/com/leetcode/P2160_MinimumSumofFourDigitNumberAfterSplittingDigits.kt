package com.leetcode

/**
 * sort
 * sum
 */
fun minimumSum(num: Int): Int {
    val sorted = num.toString().toCharArray().sorted()
    fun char2Int(a1: Char, a2: Char) = ("" + a1 + a2).toInt()

    return char2Int(sorted[0], sorted[2]) + char2Int(sorted[1], sorted[3])
}
