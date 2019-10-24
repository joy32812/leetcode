package com.leetcode

fun missingNumber(arr: IntArray): Int {

    val diff = (arr.last() - arr.first()) / arr.size
    for (i in 1 until arr.size) {
        if (arr[i - 1] + diff != arr[i]) return arr[i - 1] + diff
    }

    return 0
}

fun main() {
    println(missingNumber(intArrayOf(5,7,11,13)))
    println(missingNumber(intArrayOf(15,13,12)))
}
