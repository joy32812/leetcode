package com.leetcode

/**
 * binary search
 *
 * Or greedy
 */
fun longestSubsequence(s: String, k: Int): Int {

    var l = 0
    var r = s.length + 1

    val zeroNum = s.count { it == '0' }

    fun okay(x: Int): Boolean {
        if (x <= zeroNum) return true

        val need = x - zeroNum
        if (need > 40) return false

        var cnt = 0

        val sb = StringBuilder()
        for (i in s.indices.reversed()) {
            if (s[i] == '0') sb.append("0")
            else {
                cnt ++
                sb.append("1")
                if (cnt == need) break
            }
        }

        val s = sb.toString().reversed()
        if (s.length > 40) return false

        return s.toLong(2) <= k
    }

    while (l < r) {
        val m = (l + r) / 2
        if (!okay(m)) r = m
        else l = m + 1
    }

    return l - 1
}
