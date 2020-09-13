package com.leetcode

/**
 * easy
 * get the sum for each row and col
 */
fun numSpecial(mat: Array<IntArray>): Int {

    val row = mat.map { it.sum() }
    val col = (0 until mat[0].size).map { j -> mat.map { it[j] }.sum() }

    var ans = 0
    for (i in mat.indices) {
        for (j in mat[0].indices) {
            if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) ans ++
        }
    }

    return ans
}


fun main() {

}
