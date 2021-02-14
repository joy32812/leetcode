package com.leetcode

/**
 * incr cnt if it equals previous, otherwise set cnt = 1
 * sum by cnt
 */
fun countHomogenous(s: String): Int {
    val MOD = 1_000_000_000 + 7
    var ans = 0L

    var cnt = 0L
    var cur = '_'
    s.forEach {
        cnt = if (it != cur) 1L else cnt + 1
        cur = it
        ans = (ans + cnt) % MOD
    }
    return ans.toInt()
}

fun main() {
    println(countHomogenous("abbcccaa"))
}
