package com.leetcode

fun targetIndices(nums: IntArray, target: Int): List<Int> {

    return nums.sorted().withIndex().filter { it.value == target }.map { it.index }

}
