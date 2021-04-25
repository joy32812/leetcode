package com.leetcode

/**
 * easy
 * Int.toString(radix: Int)
 */
fun sumBase(n: Int, k: Int): Int {
    return n.toString(k).sumBy { it - '0' }
}
