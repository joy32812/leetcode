package com.leetcode

/**
 * two loops
 */
fun countHillValley(nums: IntArray): Int {

    val list = mutableListOf(nums[0])

    for (i in 1 until nums.size) {
        if (nums[i] != nums[i - 1]) list += nums[i]
    }

    return (1 until list.size - 1).count {
        (list[it] > list[it - 1] && list[it] > list[it + 1]) ||
        (list[it] < list[it - 1] && list[it] < list[it + 1])
    }
}
