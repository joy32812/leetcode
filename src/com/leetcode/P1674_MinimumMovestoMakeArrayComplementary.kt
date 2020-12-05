package com.leetcode

/**
 * Great question
 * https://leetcode.com/problems/minimum-moves-to-make-array-complementary/discuss/953078/C%2B%2B-Prefix-sum-O(n-%2B-limit)-with-detailed-examples
 */
fun minMoves(nums: IntArray, limit: Int): Int {
    val n = nums.size

    val dp = Array(2 * limit + 1) {0}
    for (i in 0 until n / 2) {
        val aa = nums[i]
        val bb = nums[n - i - 1]

        val l = Math.min(aa, bb) + 1
        var m = aa + bb
        var r = Math.max(aa, bb) + limit + 1

        if(l <= 2 * limit) dp[l] --
        if (m <= 2 * limit) dp[m] --
        if (m + 1 <= 2 * limit) dp[m + 1] ++
        if (r <= 2 * limit) dp[r] ++
    }

    var sum = 0
    var ans = 0
    for (i in 2..limit * 2) {
        sum += dp[i]
        ans = Math.min(ans, sum)
    }

    return n + ans
}

fun main() {
    println(minMoves(intArrayOf(1, 2, 2, 1), 2))
    println(minMoves(intArrayOf(1, 2, 1, 2), 2))
}
