package com.leetcode

import java.util.*

/**
 * TreeMap
 * keep counting when iterating the array
 */
fun maxScoreIndices(nums: IntArray): List<Int> {
    val ansMap = TreeMap<Int, MutableList<Int>>()

    var left = 0
    var right = nums.count { it == 1 }
    ansMap.getOrPut(left + right) { mutableListOf() } += 0

    for (i in nums.indices) {
        if (nums[i] == 0) left ++
        else right --

        ansMap.getOrPut(left + right) { mutableListOf() } += i + 1
    }

    return ansMap.lastEntry().value
}
