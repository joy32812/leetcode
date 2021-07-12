package com.leetcode

/**
 * easy
 */
fun getConcatenation(nums: IntArray): IntArray {
    return (nums.toList() + nums.toList()).toIntArray()
}

