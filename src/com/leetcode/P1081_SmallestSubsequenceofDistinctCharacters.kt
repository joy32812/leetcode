package com.leetcode


fun smallestSubsequence(text: String): String {

    val cntMap = mutableMapOf<Char, Int>()
    text.groupBy { it }.forEach {cntMap[it.key] = it.value.size}

    var now = 'z'
    var pos = -1
    for (i in 0 until text.length) {
        val c = text[i]
        if (now > c) {
            now = c
            pos = i
        }
        cntMap[c] = cntMap[c]!! - 1

        if (cntMap[c] == 0) return now + smallestSubsequence(text.substring(pos + 1).replace("" + now, ""))
    }

    return ""
}

fun main() {
    println(smallestSubsequence("cdadabcc"))
    println(smallestSubsequence("abcd"))
    println(smallestSubsequence("ecbacba"))
    println(smallestSubsequence("leetcode"))
}