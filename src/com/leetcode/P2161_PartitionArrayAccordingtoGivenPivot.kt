package com.leetcode

/**
 * filter and merge
 */
fun pivotArray(nums: IntArray, pivot: Int): IntArray {

    val smalls = nums.filter { it < pivot }
    val bigs = nums.filter { it > pivot }

    val count = nums.count { it == pivot }

    val ans = mutableListOf<Int>()
    ans.addAll(smalls)
    ans.addAll((1..count).map { pivot })
    ans.addAll(bigs)

    return ans.toIntArray()
}

