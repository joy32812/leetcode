package com.leetcode

import java.util.*

/**
 * TreeMap or Sort
 */
fun reductionOperations(nums: IntArray): Int {

    val treeMap = TreeMap<Int, Int>()
    for (d in nums) treeMap[d] = (treeMap[d] ?: 0) + 1

    var ans = 0
    while (treeMap.size > 1) {
        val entry = treeMap.pollLastEntry()
        ans += entry.value

        val nextEntry = treeMap.pollLastEntry()
        treeMap[nextEntry.key] = entry.value + nextEntry.value
    }

    return ans
}
