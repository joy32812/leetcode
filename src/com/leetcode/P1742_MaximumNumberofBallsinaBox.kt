package com.leetcode

/**
 * easy
 * map -> groupBy -> maxBy
 */
fun countBalls(lowLimit: Int, highLimit: Int): Int {
    return (lowLimit..highLimit).map { it.toString().sumBy { it - '0' } }.groupBy { it }.maxBy { it.value.size }!!.value.size
}
