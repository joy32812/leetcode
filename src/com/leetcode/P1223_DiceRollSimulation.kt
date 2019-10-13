package com.leetcode


/**
 * dp
 * dp[i][j][k]:
 * when roll ith time, end with k of j   like j, jj, jjj, jjjj
 */
fun dieSimulator(n: Int, rollMax: IntArray): Int {

    val dp = Array(n + 1) { Array(6) { Array(16) {0L} } }

    val mod = 1_000_000_000 + 7L

    for (i in 1..n) {

        var total = 0L
        for (j in 0 until 6) {
            for (k in 0 until 16) total = (total + dp[i - 1][j][k]) % mod
        }
        if (i == 1) total = 1L
        val selfs = dp[i - 1].map { it.sum() }

        for (j in 0 until 6) {

            dp[i][j][1] = total - selfs[j]
            for (k in 2..rollMax[j]) {
                dp[i][j][k] = dp[i - 1][j][k - 1]
            }
        }
    }


    return (dp[n].map { it.sum() % mod + mod }.sum() % mod).toInt()

}

fun main() {

    println(dieSimulator(2, intArrayOf(1, 1, 2, 2, 2, 3)))
    println(dieSimulator(2, intArrayOf(1, 1, 1, 1, 1, 1)))
    println(dieSimulator(3, intArrayOf(1, 1, 1, 2, 2, 3)))
    println(dieSimulator(30, intArrayOf(2, 3, 1, 2, 1, 2)))

}
