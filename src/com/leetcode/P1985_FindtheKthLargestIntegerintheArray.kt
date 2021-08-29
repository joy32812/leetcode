package com.leetcode

import java.math.BigInteger

/**
 * BigInteger
 */
fun kthLargestNumber(nums: Array<String>, k: Int): String {
    val sorted = nums.map { BigInteger(it) }.sorted()
    return sorted[nums.size - k].toString()
}
