package com.leetcode

/**
 * Double binary search
 */
fun kthSmallestProduct(nums1: IntArray, nums2: IntArray, k: Long): Long {

    val orderNums2 = nums2.toList()
    val reversedNums2 = nums2.reversed()
    fun doGetLessEqual(a: Long, p: Long, nums: List<Int>): Long {
        if (a * nums.first() > p) return 0

        var l = 0
        var r = nums.size
        while (l < r) {
            val m = (l + r) / 2
            if (a * nums[m] > p) r = m
            else l = m + 1
        }
        return 1L * l
    }

    fun getLessEqual(a: Long, p: Long): Long {
        if (a > 0) return doGetLessEqual(a, p, orderNums2)
        if (a < 0) return doGetLessEqual(a, p, reversedNums2)

        return if (p >= 0) 1L * nums2.size else 0
    }


    // min and max will be in this list.
    val limits = listOf(
        1L * nums1[0] * nums2[0],
        1L * nums1[0] * nums2.last(),
        1L * nums1.last() * nums2[0],
        1L * nums1.last() * nums2.last()
    )
    var l = limits.min()!!
    var r = limits.max()!!
    while (l < r) {
        val m = l + (r - l) / 2

        var lessEqualCnt = nums1.map { getLessEqual(1L * it, m) }.sum()
        if (lessEqualCnt >= k) r = m
        else l = m + 1
    }

    return l
}
