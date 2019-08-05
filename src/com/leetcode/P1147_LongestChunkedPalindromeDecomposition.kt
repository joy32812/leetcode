package com.leetcode

fun longestDecomposition(text: String): Int {
    val n = text.length
    val ans = Array(n) { IntArray(n) }

    fun dfs(text: String, l: Int, r: Int): Int {
        if (l > r) return 0
        if (ans[l][r] > 0) return ans[l][r]
        ans[l][r] = 1

        for (k in 1 until r - l + 1) {
            if (text.substring(l, l + k) == text.substring(r + 1 - k, r + 1)) {
                ans[l][r] = Math.max(ans[l][r], 2 + dfs(text, l + k, r - k))
            }
        }

        return ans[l][r]
    }


    return dfs(text, 0, n - 1)
}

