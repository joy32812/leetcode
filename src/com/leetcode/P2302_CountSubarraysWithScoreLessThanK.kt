package com.leetcode

/**
 * Slide Window
 */
fun countSubarrays(nums: IntArray, k: Long): Long {
    var ans = 0L
    var r = 0
    var sum = 0L

    for (i in nums.indices) {
        while (r < nums.size && 1L * (r - i + 1) * (sum + nums[r]) < k) {
            sum += nums[r]
            r ++
        }
        ans += r - i
        sum -= nums[i]
    }

    return ans
}
