package com.leetcode

import java.util.*

/**
 * find closest bigger element using stack
 * pre-sum
 */
fun maxSumMinProduct(nums: IntArray): Int {

    val presum = Array(nums.size) { 0L }
    for (i in nums.indices) presum[i] = (if (i - 1 >= 0) presum[i - 1] else 0) + nums[i]

    val left = Array(nums.size) { -1 }
    val right = Array(nums.size) { nums.size }
    val stack = Stack<Int>()

    for (i in nums.indices) {
        while (stack.isNotEmpty() && nums[stack.peek()] >= nums[i]) stack.pop()
        if (stack.isNotEmpty()) left[i] = stack.peek()

        stack.add(i)
    }

    stack.clear()
    for (i in nums.indices.reversed()) {
        while (stack.isNotEmpty() && nums[stack.peek()] >= nums[i]) stack.pop()
        if (stack.isNotEmpty()) right[i] = stack.peek()

        stack.add(i)
    }

    fun getSum(i: Int, j: Int): Long {
        return presum[j] - (if (i - 1 >= 0) presum[i - 1] else 0)
    }

    val MOD = 1_000_000_000 + 7;
    var ans = 0L
    for (i in nums.indices) {
        ans = Math.max(ans, getSum(left[i] + 1, right[i] - 1) * nums[i])
    }

    return (ans % MOD).toInt()
}

fun main() {
    println(maxSumMinProduct(intArrayOf(1, 2, 3, 2)))
}
