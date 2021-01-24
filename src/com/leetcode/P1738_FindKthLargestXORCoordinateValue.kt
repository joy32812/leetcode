package com.leetcode

fun kthLargestValue(matrix: Array<IntArray>, k: Int): Int {
    val m = matrix.size
    var n = matrix[0].size

    val dpGrid = Array(m) { Array(n) {0} }
    val dpRow = Array(m) { Array(n) {0} }

    fun getValue(arr: Array<Array<Int>>, x: Int, y: Int): Int {
        if (x < 0 || y < 0) return 0
        return arr[x][y]
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            dpGrid[i][j] = matrix[i][j] xor getValue(dpGrid, i - 1, j) xor getValue(dpRow, i, j - 1)
            dpRow[i][j] = matrix[i][j] xor getValue(dpRow, i, j - 1)
        }
    }

    return dpGrid.flatten().sortedDescending().get(k - 1)
}

fun main() {

}

