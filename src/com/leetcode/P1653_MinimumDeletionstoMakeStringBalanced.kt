package com.leetcode

fun minimumDeletions(s: String): Int {
    val n = s.length

    val leftB = Array(n) { 0 }
    val rightA = Array(n) { 0 }

    for (i in s.indices) {
        leftB[i] = (if (i - 1 >= 0) leftB[i - 1] else 0) + (if (s[i] == 'b') 1 else 0)
    }
    for (i in s.indices.reversed()) {
        rightA[i] = (if (i + 1 < n) rightA[i + 1] else 0) + (if (s[i] == 'a') 1 else 0)
    }

    return s.indices.map { i -> (if (i - 1 >= 0) leftB[i - 1] else 0) + (if (i + 1 < n) rightA[i + 1] else 0) }.min()!!
}
