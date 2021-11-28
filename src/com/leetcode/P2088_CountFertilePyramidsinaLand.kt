package com.leetcode

/**
 * Presum + Stack Pyramid
 */
fun countPyramids(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size

    fun getCount(g: Array<IntArray>): Int {
        val preSum = Array(m) { Array(n) { 0 } }

        for (i in g.indices) {
            for (j in g[i].indices) {
                preSum[i][j] = (if (j - 1 < 0) 0 else preSum[i][j - 1]) + g[i][j]
            }
        }

        var ans = 0

        fun getSum(row: Int, l: Int, r: Int) = if (l - 1 < 0) preSum[row][r] else preSum[row][r] - preSum[row][l - 1]

        for (i in g.indices) {
            for (j in g[i].indices) {
                if (g[i][j] == 0) continue

                for (h in 2 until m + 1) {
                    val row = i + (h - 1)
                    val l = j - (h - 1)
                    val r = j + (h - 1)
                    if (row >= m || l < 0 || r >= n) break

                    if (getSum(row, l, r) == r - l + 1) ans ++
                    else break
                }
            }
        }

        return ans
    }

    return getCount(grid) + getCount(grid.reversedArray())
}
