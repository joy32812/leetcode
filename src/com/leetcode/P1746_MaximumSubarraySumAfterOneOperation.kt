package com.leetcode

fun maxSumAfterOperation(nums: IntArray): Int {
    val ll = Array(nums.size) {0}
    val rr = Array(nums.size) {0}

    var sum = 0
    for (i in nums.indices) {
        sum += nums[i]
        ll[i] = sum
        if (sum < 0) sum = 0
    }

    sum = 0
    for (i in nums.indices.reversed()) {
        sum += nums[i]
        rr[i] = sum
        if (sum < 0) sum = 0
    }

    return nums.indices.map { i ->
        val left = if (i - 1 < 0 || ll[i - 1] < 0) 0 else ll[i - 1]
        val right = if (i + 1 >= nums.size || rr[i + 1] < 0) 0 else rr[i + 1]
        left + right + nums[i] * nums[i]
    }.max()!!
}

fun main() {
    println(maxSumAfterOperation(intArrayOf(2, -1, -4, -3)))
}

