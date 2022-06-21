package com.leetcode

/**
 * easy
 * firstOrNull()
 */
fun greatestLetter(s: String): String {

    return ('Z' downTo 'A').firstOrNull { it in s && it.toLowerCase() in s }?.toString() ?: ""

}

