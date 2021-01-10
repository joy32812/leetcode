package com.leetcode

/**
 * easy
 */
fun decode(encoded: IntArray, first: Int): IntArray {
    val ans = mutableListOf(first)
    encoded.forEach { ans += ans.last() xor it }
    return ans.toIntArray()
}
