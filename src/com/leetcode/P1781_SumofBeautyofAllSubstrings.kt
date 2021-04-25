package com.leetcode

fun beautySum(s: String): Int {

    val n = s.length
    val counts = Array(n) { Array(26) { 0 } }

    for (i in s.indices) {
        for (j in 0 until 26) counts[i][j] = (if (s[i] - 'a' == j) 1 else 0) + (if (i - 1 >= 0) counts[i - 1][j] else 0)
    }

    fun work(s: Int, t: Int): Int {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE


        for (j in 0 until 26) {
            val countT = counts[t][j]
            val countS = if (s - 1 >= 0) counts[s - 1][j] else 0
            if (countT == countS) continue
            min = Math.min(min, countT- countS)
            max = Math.max(max, countT - countS)
        }
        return max - min
    }

    var ans = 0
    for (i in s.indices) {
        for (j in i + 1 until s.length) {
            ans += work(i, j)
        }
    }

    return ans
}
