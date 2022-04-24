package com.leetcode


/**
 * reduce
 */

fun intersection(nums: Array<IntArray>): List<Int> {

    return nums.map { it.toSet() }.reduce { acc, ints -> acc.intersect(ints) }.toList().sorted()
}
