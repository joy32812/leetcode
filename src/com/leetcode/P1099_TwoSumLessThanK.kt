package com.leetcode


fun twoSumLessThanK(A: IntArray, K: Int): Int {

    var ans = -1

    for (i in 0 until A.size) {
        for (j in i + 1 until A.size) {
            if (A[i] + A[j] < K) ans = Math.max(ans, A[i] + A[j])
        }
    }

    return ans
}