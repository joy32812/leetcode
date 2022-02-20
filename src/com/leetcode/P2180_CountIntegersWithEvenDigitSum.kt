package com.leetcode

/**
 * easy count
 */
fun countEven(num: Int): Int {
    return (1..num).count { it.toString().sumBy { it - '0' } % 2 == 0 }
}
