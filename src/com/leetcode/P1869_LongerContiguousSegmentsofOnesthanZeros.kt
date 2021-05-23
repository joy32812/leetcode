package com.leetcode

/**
 * easy
 */
fun checkZeroOnes(s: String): Boolean {
    val one = s.split("0").map { it.length }.max() ?: 0
    val zero = s.split("1").map { it.length }.max() ?: 0
    return one > zero
}
