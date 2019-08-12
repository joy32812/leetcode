package com.leetcode


fun isMajorityElement(nums: IntArray, target: Int): Boolean {
    if (target !in nums) return false
    return nums.groupBy { it }[target]!!.size > nums.size / 2
}