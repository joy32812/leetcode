package com.leetcode

fun longestNiceSubstring(s: String): String {

    var ans = ""
    fun okay(t: String): Boolean {
        val set = t.groupBy { it }.keys
        return (0..26).all { ((('a' + it) in set) && (('A' + it) in set)) || ((('a' + it) !in set) && (('A' + it) !in set)) }
    }
    for (i in s.indices) {
        for (j in i until s.length) {
            val t = s.substring(i..j)
            if (t.length > ans.length && okay(t)) ans = t
        }
    }

    return ans
}
