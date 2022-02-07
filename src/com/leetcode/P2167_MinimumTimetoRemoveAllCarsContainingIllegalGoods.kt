package com.leetcode

/**
 * one-pass
 */
fun minimumTime(s: String): Int {

    var left = 0
    var ans = s.length

    for (i in s.indices) {
        left = Math.min(left + (s[i] - '0') * 2, i + 1)
        ans = Math.min(ans, left + s.length - i - 1)
    }

    return ans
}
