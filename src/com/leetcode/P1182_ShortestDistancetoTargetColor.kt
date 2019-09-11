package com.leetcode

fun shortestDistanceColor(colors: IntArray, queries: Array<IntArray>): List<Int> {

    val n = colors.size
    val dp = Array(n) { Array(4) {Int.MAX_VALUE} }

    fun getValue(x: Int) = if (x == Int.MAX_VALUE) x else x + 1

    for (i in colors.indices) {
        if (i - 1 >= 0) (1..3).forEach { dp[i][it] = Math.min(dp[i][it], getValue(dp[i - 1][it])) }
        dp[i][colors[i]] = 0
    }

    for (i in n - 1 downTo 0) {
        if (i + 1 < n) (1..3).forEach { dp[i][it] = Math.min(dp[i][it], getValue(dp[i + 1][it])) }
        dp[i][colors[i]] = 0
    }

    return queries.map { if (dp[it[0]][it[1]] == Int.MAX_VALUE) -1 else dp[it[0]][it[1]] }
}

fun main() {

    println(shortestDistanceColor(intArrayOf(1,1,2,1,3,2,2,3,3), arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 2),
            intArrayOf(6, 1)
    )))

}
