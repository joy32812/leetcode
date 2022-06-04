package com.leetcode

import java.util.Stack

/**
 * stack
 */
fun totalSteps(nums: IntArray): Int {
    val stack = Stack<Int>()
    val dp = Array(nums.size) { 0 }

    for (i in nums.indices.reversed()) {
        while (stack.isNotEmpty() && nums[i] > nums[stack.peek()]) {
            dp[i] = maxOf(dp[i] + 1, dp[stack.peek()])
            stack.pop()
        }
        stack.push(i)
    }

    return dp.max()!!
}
