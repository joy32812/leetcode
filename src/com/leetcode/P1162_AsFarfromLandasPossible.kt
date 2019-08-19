package com.leetcode

import java.util.*


fun maxDistance(grid: Array<IntArray>): Int {
    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)




    val m = grid.size
    val n = grid[0].size
    val total = grid.flatMap { it.toList() }.filter { it == 0 }.size
    if (total == 0 || total == m * n) return -1


    val dp = Array(m) { Array(n) {Int.MAX_VALUE} }
    val inQ = mutableListOf<Int>()
    val Q = LinkedList<Int>()

    val N = 1000

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == 1) {
                dp[i][j] = 0

                Q += i * N + j
                inQ += i * N + j
            }
        }
    }

    while (!Q.isEmpty()) {
        val tp = Q.poll()
        inQ.remove(tp)

        val x = tp / N
        val y = tp % N

        for (k in 0 until dx.size) {
            val tx = x + dx[k]
            val ty = y + dy[k]

            if (tx < 0 || tx >= m || ty < 0 || ty >=n || grid[tx][ty] == 1) continue

            if (dp[tx][ty] > dp[x][y] + 1) {
                dp[tx][ty] = dp[x][y] + 1

                val key = tx * N + ty
                if (key !in inQ) {
                    inQ += key
                    Q += key
                }
            }
        }
    }

    return dp.flatMap { it.toList() }.max()!!
}


fun main() {

}