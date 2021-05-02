package com.leetcode

/**
 * easy
 */
fun replaceDigits(s: String): String {
    return s.mapIndexed { index, c -> if (index % 2 == 0) c else s[index - 1] + (c - '0') }.joinToString("")
}
