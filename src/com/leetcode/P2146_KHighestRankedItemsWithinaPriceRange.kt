package com.leetcode

import java.util.*

/**
 * BFS + compare
 */
fun highestRankedKItems(grid: Array<IntArray>, pricing: IntArray, start: IntArray, k: Int): List<List<Int>> {
    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, 1, -1)

    val n = grid.size
    val m = grid[0].size

    val distance = Array(n) { Array(m) { Int.MAX_VALUE } }

    val Q = LinkedList<Pair<Int, Int>>(listOf(Pair(start[0], start[1])))
    distance[start[0]][start[1]] = 0

    while (Q.isNotEmpty()) {
        val (x, y) = Q.poll()

        for (k in dx.indices) {
            val tx = x + dx[k]
            val ty = y + dy[k]

            if (tx !in 0 until n || ty !in 0 until m) continue
            if (grid[tx][ty] == 0) continue
            if (distance[tx][ty] != Int.MAX_VALUE) continue

            distance[tx][ty] = distance[x][y] + 1
            Q += Pair(tx, ty)
        }
    }

    val cand = mutableListOf<Pair<Int, Int>>()
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (distance[i][j] == Int.MAX_VALUE) continue
            if (grid[i][j] <= 1) continue
            if (grid[i][j] !in pricing[0]..pricing[1]) continue

            cand += Pair(i, j)
        }
    }

    return cand.sortedWith(compareBy({ distance[it.first][it.second] }, { grid[it.first][it.second] }, { it.first }, { it.second }))
        .map { listOf(it.first, it.second) }
        .take(k)
}

