package com.leetcode

import kotlin.math.absoluteValue

/**
 * find the closest abs
 * filter
 * max
 */
fun findClosestNumber(nums: IntArray): Int {

    val close = nums.map { it.absoluteValue }.min()
    return nums.filter { it.absoluteValue == close }.max()!!

}

fun main() {

    println("Hello")

}
