package com.leetcode

/**
 * easy
 */
fun squareIsWhite(coordinates: String): Boolean {
    val a = coordinates[0] - 'a'
    var b = coordinates[1] - '1'
    return a % 2 != b % 2
}

