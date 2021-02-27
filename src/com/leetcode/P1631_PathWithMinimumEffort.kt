package com.leetcode

/**
 * binary search + dfs
 */
fun minimumEffortPath(heights: Array<IntArray>): Int {
    val dx = listOf(0, 0, 1, -1)
    val dy = listOf(1, -1, 0, 0)
    val m = heights.size
    val n = heights[0].size

    fun canAchieve(effort: Int): Boolean {
        val dp = Array(m) { Array(n) { false } }
        fun dfs(x: Int, y: Int) {
            if (dp[x][y]) return

            dp[x][y] = true
            for (i in dx.indices) {
                val tx = x + dx[i]
                val ty = y + dy[i]
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || Math.abs(heights[x][y] - heights[tx][ty]) > effort) continue
                dfs(tx, ty)
            }
        }

        dfs(0, 0)
        return dp[m - 1][n - 1]
    }


    var l = 0
    var r = 1000_000 + 10
    while (l < r) {
        val m = (l + r) / 2
        if (canAchieve(m)) r = m
        else l = m + 1
    }
    return l
}

fun main() {

//    [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
    println(minimumEffortPath(
        arrayOf(
            intArrayOf(1,2,1,1,1),
            intArrayOf(1,2,1,2,1),
            intArrayOf(1,2,1,2,1),
            intArrayOf(1,2,1,2,1),
            intArrayOf(1,1,1,2,1)
        )
    ))

}

