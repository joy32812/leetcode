package com.leetcode

/**
 * binary search
 */
fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
    val n = answerKey.length
    val preSum = Array(n) { 0 }
    for (i in answerKey.indices) preSum[i] = (if (i - 1 >= 0) preSum[i - 1] else 0) + (if (answerKey[i] == 'T') 1 else 0)

    fun rangeSum(l: Int, r: Int) = preSum[r] - (if (l - 1 >= 0) preSum[l - 1] else 0)

    fun okay(m: Int): Boolean {
        return answerKey.indices.any { it + m <= n && (rangeSum(it, it + m - 1) + k >= m || k >= rangeSum(it, it + m - 1)) }
    }

    var l = 1
    var r = n + 1
    while (l < r) {
        val m = (l + r) / 2
        if (!okay(m)) r = m
        else l = m + 1
    }

    return l - 1
}

/**
 * slide-windonw
 */
fun maxConsecutiveAnswers2(answerKey: String, k: Int): Int {
    var (l, r, T, F) = listOf(0, 0, 0, 0)
    var ans = 0

    while (r < answerKey.length) {
        if (answerKey[r] == 'T') T++ else F++
        while (Math.min(T, F) > k) if (answerKey[l++] == 'T') T-- else F--

        ans = Math.max(ans, r - l + 1)
        r ++
    }

    return ans
}
