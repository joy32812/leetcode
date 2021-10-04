package com.leetcode

/**
 * freqMap
 */
fun waysToPartition(nums: IntArray, k: Int): Int {
    val n = nums.size
    val preSum = Array(n) { 0L }
    for (i in nums.indices) preSum[i] = (if (i - 1 >= 0) preSum[i - 1] else 0) + nums[i]

    val sufSum = Array(n) { 0L }
    for (i in nums.indices.reversed()) sufSum[i] = (if (i + 1 < n) sufSum[i + 1] else 0) + nums[i]


    val diffMap = mutableMapOf<Long, Int>()
    for (i in 1 until n) {
        val diff = preSum[i - 1] - sufSum[i]
        diffMap[diff] = (diffMap[diff] ?: 0) + 1
    }

    var ans = diffMap[0] ?: 0
    val rightMap = mutableMapOf<Long, Int>()


    for (i in nums.indices) {
        val diff = 0L + k - nums[i]
        ans = Math.max(ans, (diffMap[-diff] ?: 0) + (rightMap[diff] ?: 0))

        if (i + 1 < n) {
            val df = preSum[i] - sufSum[i + 1]
            diffMap[df] = diffMap[df]!! - 1

            rightMap[df] = (rightMap[df] ?: 0) + 1
        }
    }

    return ans
}
