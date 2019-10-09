package com.leetcode


fun countVowelPermutation(n: Int): Int {

    val dp = Array(n) { Array(5) {0L} }

    for (i in 0..4) dp[0][i] = 1

    val mod = 1_000_000_000 + 7L

    for (i in 1 until n) {
        dp[i][0] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]
        dp[i][1] = dp[i - 1][0] + dp[i - 1][2]
        dp[i][2] = dp[i - 1][1] + dp[i - 1][3]
        dp[i][3] = dp[i - 1][2]
        dp[i][4] = dp[i - 1][2] + dp[i -1][3]

        for (j in 0..4) dp[i][j] = dp[i][j] % mod
    }

    var ans = 0L
    for (j in 0..4) ans = (ans + dp[n - 1][j]) % mod

    return ans.toInt()
}


fun main() {

    println(countVowelPermutation(1))
    println(countVowelPermutation(2))
    println(countVowelPermutation(5))
    println(countVowelPermutation(144))


}
