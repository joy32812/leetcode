package com.leetcode

/**
 * easy
 */
fun sortEvenOdd(nums: IntArray): IntArray {

    val even = nums.filterIndexed { index, i -> index % 2 == 0 }.sorted()
    val odd = nums.filterIndexed { index, i -> index % 2 == 1 }.sortedDescending()

    return even.indices.flatMap { i -> if (i >= odd.size) listOf(even[i]) else listOf(even[i], odd[i]) }.toIntArray()
}
