package com.leetcode

/**
 * easy
 * map -> reduce
 */
fun arraySign(nums: IntArray): Int {
    fun transfer(x: Int) = if (x > 0) 1 else if (x < 0) -1 else 0
    return nums.map { transfer(it) }.reduce { acc, i ->  acc * i }
}
