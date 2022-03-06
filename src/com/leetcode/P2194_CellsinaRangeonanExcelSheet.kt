package com.leetcode


/**
 * easy
 * flatMap
 */
fun cellsInRange(s: String): List<String> {
    val c1 = s[0]
    val c2 = s[3]

    val i = s[1] - '0'
    val j = s[4] - '0'

    return (c1..c2).flatMap { c -> (i..j).map { "" + c + it } }
}
