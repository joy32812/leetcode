package com.leetcode

fun canConvertString(s: String, t: String, k: Int): Boolean {
    if (s.length != t.length) return false

    val cnts = Array(26) { 0 }
    for (i in s.indices) cnts[(t[i] + 26 - s[i]) % 26] ++

    for (i in cnts.indices) {
        if (i == 0) continue
        if (cnts[i] > k / 26 + (if (i <= k % 26) 1 else 0) ) return false
    }

    return true
}

fun main() {
    println(canConvertString("input", "ouput", 9))
}
