package com.leetcode

/**
 * you can disconnect it in at most 2 days.
 * check if the graph is not connected if we remove one
 */
fun minDays(grid: Array<IntArray>): Int {
    if (notConnected(grid)) return 0

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 1) {
                grid[i][j] = 0
                if (notConnected(grid)) return 1
                grid[i][j] = 1
            }
        }
    }

    return 2
}

val kx = intArrayOf(0, 0, 1, -1)
val ky = intArrayOf(1, -1, 0, 0)
fun notConnected(grid: Array<IntArray>): Boolean {
    val m = grid.size
    var n = grid[0].size
    val color = Array(m) {IntArray(n)}

    fun dfs(x: Int, y: Int) {
        color[x][y] = 1

        for (i in kx.indices) {
            val tx = x + kx[i]
            val ty = y + ky[i]

            if (tx >= m || tx < 0 || ty >= n || ty < 0 || grid[tx][ty] == 0) continue
            if (color[tx][ty] == 1) continue
            dfs(tx, ty)
        }
    }

    var sx = -1
    var sy = -1
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 1) {
                sx = i
                sy = j
            }
        }
    }

    if (sx == -1) return true
    dfs(sx, sy)

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 1 && color[i][j] != 1) return true
        }
    }

    return false
}

fun main() {
    println(minDays(arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))));
}
