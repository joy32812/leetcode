package com.leetcode

/**
 * brute force
 */
fun countElements(nums: IntArray): Int {

    return nums.count { d ->
        nums.find { it > d } != null && nums.find { it < d } != null
    }

}
