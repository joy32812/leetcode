package com.leetcode

/**
 * dp
 */
fun countVowels(word: String): Long {
    val n = word.length
    val sum = Array(n) { 0L }

    fun getSum(i: Int) = if (i < 0) 0 else sum[i]
    for (i in word.indices) {
        if (word[i] in "aeuio") {
            sum[i] = getSum(i - 1) + i + 1
        } else {
            sum[i] = getSum(i - 1)
        }
    }

    return sum.sum()
}

