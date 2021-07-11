package com.leetcode

import java.util.*


/**
 * BFS
 */
fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {

    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)

    val m = maze.size
    val n = maze[0].size

    val start = entrance[0] * n + entrance[1]
    val Q = LinkedList<Int>()
    val inMap = mutableMapOf<Int, Int>()

    Q.add(start)
    inMap[start] = 0

    fun isExit(x: Int, y: Int): Boolean {
        if (x == 0 || y == 0 || x == m - 1 || y == n - 1) return true
        return false
    }

    while (!Q.isEmpty()) {
        val tp = Q.poll()

        val x = tp / n
        val y = tp % n

        for (k in dx.indices) {
            val tx = x + dx[k]
            val ty = y + dy[k]
            val key = tx * n + ty

            if (tx < 0 || tx >= m || ty < 0 || ty >= n) continue
            if (maze[tx][ty] == '+') continue
            if (key in inMap) continue

            if (isExit(tx, ty)) return inMap[tp]!! + 1

            inMap[key] = inMap[tp]!! + 1
            Q.add(key)
        }


    }

    return -1
}
