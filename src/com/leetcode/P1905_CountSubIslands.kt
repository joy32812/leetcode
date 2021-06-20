package com.leetcode

/**
 * all the cell for an island in grid2, must be 1 in grid1
 */
fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
    val m = grid1.size
    val n = grid1[0].size


    var ans = 0

    fun dfs(x: Int, y: Int): Int {
        if (x < 0 || x == m || y < 0 || y == n || grid2[x][y] == 0) return 1
        grid2[x][y] = 0
        var res = 1

        res = res and dfs(x, y - 1)
        res = res and dfs(x, y + 1)
        res = res and dfs(x - 1, y)
        res = res and dfs(x + 1, y)

        return res and grid1[x][y]

    }

    for (i in grid2.indices) {
        for (j in grid2[0].indices) {
            if (grid2[i][j] == 1) ans += dfs(i, j)
        }
    }

    return ans
}

fun main() {
    println(
        countSubIslands(
            arrayOf(
                intArrayOf(1, 1, 1, 0, 0),
                intArrayOf(0, 1, 1, 1, 1),
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(1, 0, 0, 0, 0),
                intArrayOf(1, 1, 0, 1, 1)
            ),
            arrayOf(
                intArrayOf(1, 1, 1, 0, 0),
                intArrayOf(0, 0, 1, 1, 1),
                intArrayOf(0, 1, 0, 0, 0),
                intArrayOf(1, 0, 1, 1, 0),
                intArrayOf(0, 1, 0, 1, 0)

            )
        )
    )
}
