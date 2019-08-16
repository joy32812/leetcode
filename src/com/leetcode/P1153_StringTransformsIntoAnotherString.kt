package com.leetcode

fun canConvert(str1: String, str2: String): Boolean {
    if (str1 == str2) return true

    val dp = mutableMapOf<Char, Char>()
    str1.zip(str2).forEach {
        if (it.first in dp && dp[it.first] != it.second) return false
        dp[it.first] = it.second
    }
    return dp.values.toSet().size < 26
}