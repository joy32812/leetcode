package com.leetcode

/**
 * set union/intersect
 */
fun twoOutOfThree(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {
    val set1 = nums1.filter { it in nums2 || it in nums3 }.toSet()
    val set2 = nums2.filter { it in nums3 }.toSet()

    return set1.union(set2).toList()
}

