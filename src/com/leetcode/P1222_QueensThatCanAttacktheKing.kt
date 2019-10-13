package com.leetcode

/**
 * easy
 * just find the first Queen in 8 directions
 */
fun queensAttacktheKing(queens: Array<IntArray>, king: IntArray): List<List<Int>> {

    val dx = arrayOf(-1, -1,  -1, 0, 0, 1, 1, 1)
    val dy = arrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

    val qSet = queens.map { Pair(it[0], it[1]) }.toSet()

    val ans = mutableListOf<List<Int>>()

    for (k in dx.indices) {

        var (nx, ny) = king
        while (true) {

            nx += dx[k]
            ny += dy[k]

            if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8) break
            if (Pair(nx, ny) in qSet) {
                ans += mutableListOf(nx, ny)
                break
            }
        }

    }


    return ans
}

fun main() {

    println(queensAttacktheKing(
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 0),
                intArrayOf(4, 0),
                intArrayOf(0, 4),
                intArrayOf(3, 3),
                intArrayOf(2, 4)
            ),
            intArrayOf(0, 0)
    ))
}
