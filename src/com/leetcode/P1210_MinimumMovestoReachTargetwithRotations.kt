package com.leetcode

import java.util.*


/**
 * BFS
 */
fun minimumMoves(grid: Array<IntArray>): Int {


    val N = grid.size
    val Q = LinkedList<Pair<Int, Int>>()
    val cntMap = mutableMapOf<Pair<Int, Int>, Int>()


    val begin = Pair(0, 1)
    Q.push(begin)
    cntMap[begin] = 0

    val dest = Pair((N - 1) * N + N - 2, (N - 1) * N + N - 1)

    while (!Q.isEmpty()) {
        val now = Q.poll()
        val beg = now.first
        val end = now.second

        val ax = beg / N
        val ay = beg % N

        val bx = end / N
        val by = end % N


        // right
        if (ay + 1 < N && by + 1 < N && grid[ax][ay + 1] == 0 && grid[bx][by + 1] == 0) {
            val toPair = Pair(ax * N + ay + 1, bx * N + by + 1)
            if (toPair !in cntMap) {
                cntMap[toPair] = cntMap[now]!! + 1
                Q += toPair
            }
        }


        // down
        if (ax + 1 < N && bx + 1 < N && grid[ax + 1][ay] == 0 && grid[bx + 1][by] == 0) {
            val toPair = Pair((ax + 1) * N + ay, (bx + 1) * N + by)
            if (toPair !in cntMap) {
                cntMap[toPair] = cntMap[now]!! + 1
                Q += toPair
            }
        }

        // clockwise
        if (ax == bx && ax + 1 < N && grid[ax + 1][ay] == 0 && grid[ax + 1][ay + 1] == 0) {
            val toPair = Pair(ax * N + ay, (ax + 1) * N + ay)
            if (toPair !in cntMap) {
                cntMap[toPair] = cntMap[now]!! + 1
                Q += toPair
            }
        }

        // counter clockwise
        if (ay == by && by + 1 < N && grid[ax][ay + 1] == 0 && grid[ax + 1][ay + 1] == 0) {
            val toPair = Pair(ax * N + ay, ax * N + ay + 1)
            if (toPair !in cntMap) {
                cntMap[toPair] = cntMap[now]!! + 1
                Q += toPair
            }
        }

        if (dest in cntMap) {
            return cntMap[dest]!!
        }

    }

    return -1

}


fun main() {
    println("Hello")
}
