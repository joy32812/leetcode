package com.leetcode

import kotlin.math.max

fun longestCommonSubsequence(text1: String, text2: String): Int {
    fun getValue(dp: Array<IntArray>, i: Int, j: Int): Int = if (i < 0 || j < 0) 0 else dp[i][j]

    val m = text1.length
    val n = text2.length
    val dp = Array(m) {IntArray(n)}


    for (i in 0 until m) {
        for (j in 0 until n) {
            dp[i][j] = max(getValue(dp, i, j - 1), getValue(dp, i - 1, j));

            if (text1[i] == text2[j]) dp[i][j] = max(dp[i][j], getValue(dp, i - 1, j - 1) + 1)
        }
    }


    return dp.flatMap { it.toList() }.max()!!

}

