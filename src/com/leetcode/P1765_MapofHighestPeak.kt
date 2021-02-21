package com.leetcode

import java.util.*

fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
    val dx = listOf(0, 0, 1, -1)
    val dy = listOf(1, -1, 0, 0)
    val m = isWater.size
    val n = isWater[0].size

    val ans = Array(m) { IntArray(n) {0} }

    val Q = LinkedList<Int>()
    val inQ = mutableSetOf<Int>()
    for (i in isWater.indices) {
        for (j in isWater[0].indices) {
            if (isWater[i][j] == 1) {
                Q.add(i * n + j)
                inQ.add(i * n + j)
            }
        }
    }

    while (Q.isNotEmpty()) {
        val tp = Q.pop()
        val x = tp / n
        val y = tp % n

        for (i in dx.indices) {
            val tx = x + dx[i]
            val ty = y + dy[i]

            val key = tx * n + ty
            if (tx < 0 || tx >= m || ty < 0 || ty >= n || (key in inQ)) continue
            ans[tx][ty] = ans[x][y] + 1
            Q.add(key)
            inQ.add(key)
        }
    }

    return ans

}

fun main() {
   println(highestPeak(
       arrayOf(
           intArrayOf(0, 0),
           intArrayOf(1, 1),
           intArrayOf(1, 0)
       )
   ))
}
