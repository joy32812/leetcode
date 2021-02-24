package com.leetcode

import java.util.*

fun getFood(grid: Array<CharArray>): Int {
    val dx = listOf(0, 0, 1, -1)
    val dy = listOf(1, -1, 0, 0)

    val m = grid.size
    val n = grid[0].size

    val dis = Array(m) { Array(n) { Int.MAX_VALUE } }
    val Q = LinkedList<Int>()

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == '#') {
                Q.push(i * n + j)
                dis[i][j] = 0
            }
        }
    }

    while (Q.isNotEmpty()) {
        val tp = Q.pollLast()
        val x = tp / n
        val y = tp % n

        for (i in dx.indices) {
            val tx = x + dx[i]
            val ty = y + dy[i]
            if (tx < 0 || tx >= m || ty < 0 || ty >= n || grid[tx][ty] == 'X') continue
            if (grid[tx][ty] == '*') return dis[x][y] + 1
            if (dis[tx][ty] != Int.MAX_VALUE) continue

            dis[tx][ty] = dis[x][y] + 1
            Q.push(tx * n + ty)
        }

    }

    return -1
}

fun main() {

    println(getFood(
        arrayOf(
            charArrayOf('O','O','O'),
            charArrayOf('O','#','#'),
            charArrayOf('O','O','X'),
            charArrayOf('O','O','O'),
            charArrayOf('#','O','*')
        )
    ))

}
