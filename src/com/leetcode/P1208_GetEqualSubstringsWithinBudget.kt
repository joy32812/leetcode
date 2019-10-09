package com.leetcode


fun equalSubstring(s: String, t: String, maxCost: Int): Int {

    var l = 0
    var r = 0

    var total = 0
    var ans = 0
    while (r < s.length) {
        while (total <= maxCost && r < s.length) {
            total += Math.abs(s[r] - t[r])
            if (total <= maxCost) ans = Math.max(ans, r - l + 1)
            r++
        }

        while (total > maxCost) {
            total -= Math.abs(s[l] - t[l])
            l++
        }
    }

    return ans
}


fun main() {
    println(equalSubstring("abcd", "bcdf", 3))
    println(equalSubstring("abcd", "cdef", 3))
    println(equalSubstring("abcd", "acde", 0))
    println(equalSubstring("abcd", "accd", 0))
}
