package com.leetcode

/**
 * easy
 */
fun threeConsecutiveOdds(arr: IntArray): Boolean {
    if (arr.size < 3) return false
    fun isOdd(x: Int) = x % 2 == 1
    return (2 until arr.size).any { isOdd(arr[it]) && isOdd(arr[it - 1]) && isOdd(arr[it - 2]) }
}
