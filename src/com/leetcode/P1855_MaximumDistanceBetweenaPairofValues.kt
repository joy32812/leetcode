package com.leetcode

/**
 * two points
 */
fun maxDistance(nums1: IntArray, nums2: IntArray): Int {

    var ans = 0
    var j = -1
    for (i in nums1.indices) {
        while (j + 1 < nums2.size && nums2[j + 1] >= nums1[i]) j ++
        if (nums2[0] < nums1[i] || i > j) continue

        ans = Math.max(ans, j - i)
    }

    return ans
}
