package com.leetcode

/**
 * DP + memo
 */
fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
    val m = multipliers.size
    val data = nums.filterIndexed { index, i -> index < m || index + m >= nums.size}
    val dp = Array(data.size) { Array(data.size) { Int.MAX_VALUE } }

    fun dfs(l: Int, r: Int): Int {
        val now = data.size - (r - l + 1)
        if (now >= multipliers.size) return 0
        if (l == r) return data[l] * multipliers[now]
        if (dp[l][r] != Int.MAX_VALUE) return dp[l][r]

        dp[l][r] = Math.max(
            data[l] * multipliers[now] + dfs(l + 1, r),
            data[r] * multipliers[now] + dfs(l, r - 1)
        )

        return dp[l][r]
    }

    return dfs(0, data.size - 1)
}
