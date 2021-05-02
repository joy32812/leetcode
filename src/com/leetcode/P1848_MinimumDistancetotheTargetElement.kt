package com.leetcode

/**
 * easy
 */
fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
    return nums.mapIndexed { index, i -> Pair(index, i) }.filter { it.second == target }.map { Math.abs(it.first - start) }.min()!!
}
