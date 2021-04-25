package com.leetcode


/**
 * slide window
 */
fun maxFrequency(nums: IntArray, k: Int): Int {
    nums.sort()

    var ans = 0
    var sum = 0L
    var i = 0
    for (j in nums.indices) {
        sum += nums[j]
        while (sum + k < 1L * nums[j] * (j - i + 1)) {
            sum -= nums[i]
            i ++
        }

        ans = Math.max(ans, j - i + 1)
    }

    return ans
}

/**
 * binary search + prefix sum
 */
fun maxFrequency2(nums: IntArray, k: Int): Int {

    nums.sort()
    val prefixSum = Array(nums.size) { 0L }
    for (i in nums.indices) prefixSum[i] = (if (i - 1 >= 0) prefixSum[i - 1] else 0) + nums[i]

    fun okay(x: Int): Boolean {
        for (i in nums.indices) {
            val j = i + x - 1
            if (j >= nums.size) break
            val total = prefixSum[j] - (if (i - 1 >= 0) prefixSum[i - 1] else 0)
            if (k >= 1L * nums[j] * x - total) return true
        }

        return false
    }

    var l = 1
    var r = nums.size + 1
    while (l < r) {
        val m = (l + r) / 2
        if (!okay(m)) r = m
        else l = m + 1
    }

    return l - 1
}
