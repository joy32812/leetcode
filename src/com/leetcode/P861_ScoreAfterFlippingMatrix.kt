package com.leetcode


fun matrixScore(A: Array<IntArray>): Int {

    val m = A.size
    val n = A[0].size

    var ans = m * (1 shl (n - 1))

    for (j in 1 until  n) {
        var cnt = 0
        for (i in 0 until m) {
            if (A[i][j] == A[i][0]) cnt++
        }

        ans += Math.max(cnt, m - cnt) * (1 shl (n - j - 1))
    }

    return ans
}

fun main() {
    println(matrixScore(arrayOf(
            intArrayOf(0,0,1,1),
            intArrayOf(1,0,1,0),
            intArrayOf(1,1,0,0)
    )))
}