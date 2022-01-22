package com.leetcode

/**
 * Easy
 */
fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {

    val real = mutableListOf(0L)
    for (i in differences) real += real.last() + i

    val min = real.min()!!
    val max = real.max()!!

    val now = max + lower - min
    return if (now <= upper) (upper - now + 1).toInt() else 0
}
