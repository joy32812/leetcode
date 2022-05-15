package com.leetcode

/**
 * PreSum
 */
fun waysToSplitArray(nums: IntArray): Int {

    var sum = nums.map { it.toLong() }.sum()

    var now = 0L
    var ans = 0
    for (i in 0 until nums.size - 1) {
        now += nums[i]
        sum -= nums[i]

        ans += if (now >= sum) 1 else 0

    }

    return ans
}
