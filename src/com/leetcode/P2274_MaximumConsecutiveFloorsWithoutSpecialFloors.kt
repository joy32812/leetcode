package com.leetcode

/**
 * ZipWithNext()
 */
fun maxConsecutive(bottom: Int, top: Int, special: IntArray): Int {
    val floors = mutableListOf(bottom - 1, top + 1)
    floors += special.toList()

    floors.sort()

    return floors.zipWithNext().map { it.second - it.first - 1 }.max() ?: 0
}
