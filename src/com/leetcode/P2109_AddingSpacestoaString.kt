package com.leetcode

import java.lang.StringBuilder

/**
 * easy
 */
fun addSpaces(s: String, spaces: IntArray): String {

    val sb = StringBuilder()
    var j = 0
    for (i in s.indices) {

        if (j < spaces.size && i == spaces[j]) {
            sb.append(' ')
            j ++
        }

        sb.append(s[i])
    }

    return sb.toString()
}
