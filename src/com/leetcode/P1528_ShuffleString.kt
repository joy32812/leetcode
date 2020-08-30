package com.leetcode

fun restoreString(s: String, indices: IntArray): String {
    val sIntList = s.toCharArray().map { it - 'A' }
    val zipList = sIntList zip indices.toList()

    return zipList.sortedBy { it.second }.map { it.first }.map { 'A' + it }.joinToString("")
}


fun main() {
    println(restoreString("codeleet", intArrayOf(4, 5, 6, 7, 0, 2, 1, 3)))
}
