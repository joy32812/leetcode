package com.leetcode


/**
 * zipWithNext
 * filter
 * map
 */
fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
    arr.sort()
    val min = arr.toList().zipWithNext().map { it.second - it.first }.min()!!
    return arr.toList().zipWithNext().filter { it.second - it.first == min }.map { listOf(it.first, it.second) }
}


fun main() {

    println("Hello")
}
