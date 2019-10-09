package com.leetcode



fun uniqueOccurrences(arr: IntArray): Boolean {

    val keySet = arr.toSet()
    val valSet = arr.groupBy { it }.map { it.value.size }.toSet()

    return keySet.size == valSet.size
}



fun main() {
    println("Hello")
}
