package com.leetcode

fun buildArray(nums: IntArray): IntArray {
    return nums.indices.map { nums[nums[it]] }.toIntArray()
}
