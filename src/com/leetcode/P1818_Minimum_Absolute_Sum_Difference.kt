package com.leetcode

import java.util.*

/**
 * easy
 * TreeSet
 */
fun minAbsoluteSumDiff(nums1: IntArray, nums2: IntArray): Int {
    val treeSet = TreeSet<Int>()
    nums1.forEach { treeSet.add(it) }

    val total = nums1.indices.map { 0L + Math.abs(nums1[it] - nums2[it]) }.sum()

    var ans = Long.MAX_VALUE
    for (i in nums1.indices) {
        var floor = treeSet.floor(nums2[i])
        var ceiling = treeSet.ceiling(nums2[i])

        if (floor != null) {
            ans = Math.min(ans, total - Math.abs(nums1[i] - nums2[i]) + Math.abs(nums2[i] - floor))
        }
        if (ceiling != null) {
            ans = Math.min(ans, total - Math.abs(nums1[i] - nums2[i]) + Math.abs(nums2[i] - ceiling))
        }
    }

    val MOD = 1_000_000_000 + 7
    return (ans % MOD).toInt()
}
