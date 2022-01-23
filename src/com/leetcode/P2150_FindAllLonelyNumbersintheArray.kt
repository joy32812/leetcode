package com.leetcode

/**
 * group by
 */
fun findLonely(nums: IntArray): List<Int> {
    val groupBy = nums.groupBy { it }.mapValues { it.value.size }

    return nums.filter { groupBy[it] == 1 && (it - 1 !in groupBy) && (it + 1 !in groupBy) }
}
