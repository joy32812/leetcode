package com.leetcode

/**
 * easy math
 */
fun totalMoney(n: Int): Int {
    val x = n / 7
    val y = n % 7

    return x * 28 + 7 * x * (x - 1) / 2 + y * (y + 1) / 2 + x * y
}
