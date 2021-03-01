package com.leetcode


fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
    return l.indices.map { i ->
        val range = nums.filterIndexed { index, _ -> index in l[i]..r[i] }.sorted()
        (1 until range.size).map { range[it] - range[it - 1] }.toSet().size == 1
    }
}

