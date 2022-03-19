package com.leetcode

import kotlin.math.abs

fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {

    return nums.indices.filter { i -> nums.indices.any { j -> abs(i - j) <= k && nums[j] == key } }

}
