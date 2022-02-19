package com.leetcode

/**
 * easy
 */
fun countPairs(nums: IntArray, k: Int): Int {

    return nums.indices.flatMap {
            i -> (i + 1 until nums.size).map { j -> Pair(i, j) }
    }.count { it.first * it.second % k == 0 && nums[it.first] == nums[it.second] }

}
