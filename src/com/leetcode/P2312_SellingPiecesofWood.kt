package com.leetcode

/**
 * DP, Top to bottom.
 */
fun sellingWood(m: Int, n: Int, prices: Array<IntArray>): Long {

    val dp = Array(m + 1) { Array(n + 1) { -1L } }
    val gbHeight = prices.groupBy { it[0] }
    val gbWidth = prices.groupBy { it[1] }

    fun cut(h: Int, w: Int): Long {
        if (h == 0 || w == 0) return 0L
        if (dp[h][w] != -1L) return dp[h][w]

        var ans = 0L

        // same height
        val hs = gbHeight[h] ?: emptyList()
        for ((hi, wi, price) in hs) {
            if (wi > w) continue

            ans = maxOf(
                ans,
                price + cut(h, w - wi)
            )
        }

        // same width
        val ws = gbWidth[w] ?: emptyList()
        for ((hi, wi, price) in ws) {
            if (hi > h) continue

            ans = maxOf(
                ans,
                price + cut(h - hi, w)
            )
        }

        // cut height
        for (i in 1 until h) {
            ans = maxOf(
                ans,
                cut(i, w) + cut(h - i, w)
            )
        }

        // cut width
        for (i in 1 until w) {
            ans = maxOf(
                ans,
                cut(h, i) + cut(h, w - i)
            )
        }


        dp[h][w] = ans
        return ans
    }

    return cut(m, n)
}
