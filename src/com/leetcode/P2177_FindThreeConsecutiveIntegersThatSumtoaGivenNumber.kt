package com.leetcode


/**
 * easy
 */
fun sumOfThree(num: Long): LongArray {

    if (num % 3 != 0L) return longArrayOf()

    val k = num / 3
    return longArrayOf(k - 1, k, k + 1)
}
