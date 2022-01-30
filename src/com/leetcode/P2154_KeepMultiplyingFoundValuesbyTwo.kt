package com.leetcode

/**
 * easy while-loop
 */
fun findFinalValue(nums: IntArray, original: Int): Int {
    var now = original
    while (now in nums) now *= 2

    return now
}
