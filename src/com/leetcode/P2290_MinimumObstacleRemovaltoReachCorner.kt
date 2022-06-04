package com.leetcode

import java.util.*

/**
 * short-path
 */
fun minimumObstacles(grid: Array<IntArray>): Int {

    val m = grid.size
    val n = grid[0].size

    val dis = Array(m) { Array(n) { Int.MAX_VALUE } }
    dis[0][0] = 0

    val Q = LinkedList<Pair<Int, Int>>()
    Q += 0 to 0

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    while (Q.isNotEmpty()) {
        val (x, y) = Q.poll()

        for (k in dx.indices) {
            val tx = x + dx[k]
            val ty = y + dy[k]

            if (tx < 0 || tx >= m || ty < 0 || ty >= n) continue
            val w = grid[tx][ty]

            if (dis[tx][ty] > dis[x][y] + w) {
                dis[tx][ty] = dis[x][y] + w
                Q += tx to ty
            }
        }
    }

    return dis[m - 1][n - 1]
}
