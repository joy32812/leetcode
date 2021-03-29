package com.leetcode

import java.lang.StringBuilder

/**
 * brute force
 */
fun evaluate(s: String, knowledge: List<List<String>>): String {
    val toMap = knowledge.map { it[0] to it[1] }.toMap()

    var sb = StringBuilder()
    var i = 0
    while (i < s.length) {
        if (s[i] == '(') {
            val nextPos = s.indexOf(')', i)
            val now = s.substring(i + 1 .. nextPos - 1)
            sb.append(toMap[now] ?: '?')
            i = nextPos
        } else {
            sb.append(s[i])
        }
        i++
    }

    return sb.toString()
}
