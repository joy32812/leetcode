package com.leetcode

fun hasAllCodes(s: String, k: Int): Boolean {
    if (s.length < k) return false

    val all = HashSet<Int>();
    var now = s.substring(0, k).toInt(2)
    all += now

    for (i in k until s.length) {
        now = now and ((1 shl k -1 ) - 1)
        now = (now shl 1) + (s[i] - '0')
        all += now
    }
    return all.size == 1 shl k;
}

fun main() {
    println(hasAllCodes("00110110", 2))
}
