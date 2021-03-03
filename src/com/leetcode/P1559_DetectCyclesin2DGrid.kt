package com.leetcode

fun containsCycle(grid: Array<CharArray>): Boolean {
    val m = grid.size
    val n = grid[0].size

    val visited = mutableSetOf<Int>()

    val dx = listOf(0, 0, 1, -1)
    val dy = listOf(1, -1, 0, 0)
    fun hasCycle(p: Int, q: Int): Boolean {
        var hasCycle = false

        fun dfs(x: Int, y: Int, fx: Int, fy: Int) {
            val key = x * n + y
            if (key in visited) {
                hasCycle = true
                return
            }

            visited += key
            for (i in dx.indices) {
                val tx = x + dx[i]
                val ty = y + dy[i]
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || grid[x][y] != grid[tx][ty]) continue
                if (tx == fx && ty == fy) continue
                dfs(tx, ty, x, y)
            }
        }

        dfs(p, q, -1, -1)
        return hasCycle
    }

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (i * n + j in visited) continue
            if (hasCycle(i, j)) return true
        }
    }

    return false
}
