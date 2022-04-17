package com.leetcode

/**
 * chunked()
 */
fun digitSum(s: String, k: Int): String {
    fun transfer(t: String) =
        t.chunked(k).joinToString("") { str -> str.sumBy { it - '0' }.toString() }

    var now = s
    while (now.length > k) now = transfer(now)

    return now
}
