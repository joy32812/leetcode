package com.leetcode


/**
 * slide-window
 * from right to left
 */
fun subStrHash(s: String, p: Int, modulo: Int, k: Int, hashValue: Int): String {
    val n = s.length

    val ps = Array(n) { 1L % modulo }
    for (i in 1 until n) ps[i] = ps[i - 1] * p % modulo


    var now = 0L
    for (i in n - k until n) {
        now = (now + ps[i - n + k] * (s[i] - 'a' + 1) % modulo) % modulo
    }

    var ans = 0
    if (now.toInt() == hashValue) ans = n - k


    for (i in n - k - 1 downTo 0) {
        val b = i + k - 1

        now = (now - ps[k - 1] * (s[b + 1] - 'a' + 1) % modulo + modulo) % modulo
        now = now * p % modulo
        now = (now + ps[0] * (s[i] - 'a' + 1) % modulo + modulo) % modulo

        if (now.toInt() == hashValue) ans = i
    }

    return s.substring(ans until ans + k)
}

fun main() {
    println(subStrHash("leetcode", 7, 20, 2, 0))
}
