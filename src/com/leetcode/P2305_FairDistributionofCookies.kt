package com.leetcode

/**
 * dfs
 */
fun distributeCookies(cookies: IntArray, k: Int): Int {
    var ans = Int.MAX_VALUE
    val nums = Array(k) { 0 }

    fun dfs(x: Int) {
        if (x == cookies.size) {
            ans = minOf(ans, nums.max()!!)
            return
        }

        for (i in 0 until k) {
            if (nums[i] < ans) {
                nums[i] += cookies[x]
                dfs(x + 1)
                nums[i] -= cookies[x]
            }
        }
    }

    dfs(0)
    return ans
}
