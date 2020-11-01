package com.leetcode

/**
 * easy dp
 */
fun countVowelStrings(n: Int): Int {
    val dp = Array(n + 1) { Array(5) {0} }
    for (j in 0 until 5) dp[1][j] = 1

    for (i in 2..n) {
        for (j in 0 until 5) {
            dp[i][j] = dp[i - 1].filterIndexed { index, _ -> index <= j }.sum()
        }
    }

    return dp[n].sum()
}

fun main() {
    println(countVowelStrings(1))
    println(countVowelStrings(2))
    println(countVowelStrings(3))
    println(countVowelStrings(33))
    println(countVowelStrings(50))
}
