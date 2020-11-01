package com.leetcode

/**
 * Combinatorics
 */
fun kthSmallestPath(destination: IntArray, k: Int): String {

    fun getNcr(row: Int, col: Int): Int {
        var big = row + col
        var small = Math.min(row, col)
        var result = 1
        for (i in 1..small) {
            result = result * big / i
            big --
        }
        return result
    }

    fun work(row: Int, col: Int, n: Int): String {
        if (row == 0) return "H".repeat(col)
        if (col == 0) return "V".repeat(row)

        val useH = getNcr(row, col - 1)
        if (useH >= n) return "H" + work(row, col - 1, n)

        return "V" + work(row - 1, col, n - useH)
    }

    return work(destination[0], destination[1], k);
}

fun main() {
    println(kthSmallestPath(intArrayOf(2, 3), 1))
    println(kthSmallestPath(intArrayOf(2, 3), 2))
    println(kthSmallestPath(intArrayOf(2, 3), 3))
}
