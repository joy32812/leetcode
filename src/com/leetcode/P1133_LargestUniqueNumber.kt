package com.leetcode





fun largestUniqueNumber(A: IntArray): Int {
    return A.groupBy { it }.filter { it.value.size == 1 }.keys.maxBy { it } ?: -1
}

fun main() {
    println(largestUniqueNumber(intArrayOf(5,7,3,9,4,9,8,3,1)))
    println(largestUniqueNumber(intArrayOf(1, 1, 2, 2)))
}

