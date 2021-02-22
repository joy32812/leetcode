package com.leetcode

/**
 * DP top-down
 */
fun longestPalindrome(word1: String, word2: String): Int {
    val n = word1.length + word2.length
    val dp = Array(n) { Array(n) { Array(2) { -1 } } }

    fun dfs(left: Int, right: Int, flag: Int): Int {
        if (left > right) return 0
        if (dp[left][right][flag] != -1) return dp[left][right][flag]

        if (flag == 0) {
            if (left >= word1.length || right < word1.length) return 0
            if (left == right) return 1

            dp[left][right][flag] =
                if (word1[left] == word2[right - word1.length]) {
                    2 + dfs(left + 1, right - 1, 1)
                }
                else Math.max(
                    dfs(left + 1, right, 0),
                    dfs(left, right - 1, 0)
                )
        } else {
            if (left == right) return 1
            val ll = if (left >= word1.length) word2[left - word1.length] else word1[left]
            val rr = if (right < word1.length) word1[right] else word2[right - word1.length]

            dp[left][right][flag] =
            if (ll == rr) {
                2 + dfs(left + 1, right - 1, 1)
            } else Math.max(
                dfs(left + 1, right, 1),
                dfs(left, right - 1, 1)
            )
        }

        return dp[left][right][flag]
    }

    return dfs(0, word1.length + word2.length - 1, 0)
}

fun main() {


//    println(longestPalindrome("aa", "bb"))
//    println(longestPalindrome("cacb", "cbba"))
    println(longestPalindrome(
        "knzgidixqgtnaha",
        "mebxf"
    ))

}
