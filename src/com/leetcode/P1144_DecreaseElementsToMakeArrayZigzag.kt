package com.leetcode


fun movesToMakeZigzag(nums: IntArray): Int {

    val ans = arrayOf(0, 0)
    for (i in 0 until nums.size) {
        val left = if (i - 1 < 0) Int.MAX_VALUE else nums[i - 1]
        val right = if (i + 1 >= nums.size) Int.MAX_VALUE else nums[i + 1]

        ans[i % 2] += Math.max(0, nums[i] - Math.min(left, right) + 1)
    }

    return ans.min()!!
}