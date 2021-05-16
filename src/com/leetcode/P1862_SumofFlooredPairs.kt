package com.leetcode

fun sumOfFlooredPairs(nums: IntArray): Int {
    val MOD = 1_000_000_000 + 7
    val N = 3_000_00 + 10
    var preq = Array(N) { 0 }
    val presum = Array(N) { 0 }

    for (i in nums.indices) preq[nums[i]] ++
    for (i in 1 until N) presum[i] = presum[i - 1] + preq[i]

    var ans = 0L

    for (i in nums.toSet()) {
        var j = i
        while (j + i < N) {
            val cnt = presum[j + i - 1] - presum[j - 1]
            ans = (ans + 1L * cnt * j * preq[i] / i) % MOD

            j +=i
        }
    }

    return ans.toInt()
}
