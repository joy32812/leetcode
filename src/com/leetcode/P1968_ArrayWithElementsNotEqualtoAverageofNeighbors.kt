package com.leetcode


/**
 * randomization
 * or Wiggle sort
 */
fun rearrangeArray(nums: IntArray): IntArray {

    while (true) {
        val shuffled = nums.toList().shuffled()
        if ((1 until shuffled.size - 1).all { shuffled[it - 1] + shuffled[it + 1] != shuffled[it] * 2 }) return shuffled.toIntArray()
    }

    return nums
}
