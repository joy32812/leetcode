package com.leetcode


/**
 * O(N)
 */
fun missingElement2(nums: IntArray, k: Int): Int {
    val rangeList = mutableListOf<IntArray>()

    for (i in 1 until nums.size) {
        if (nums[i - 1] + 1 < nums[i]) {
            rangeList.add(intArrayOf(nums[i - 1] + 1, nums[i] - 1))
        }
    }

    var cnt = 0
    for (ia in rangeList) {
        if (k <= cnt + ia[1] - ia[0] + 1) return ia[0] + k - cnt - 1
        cnt += ia[1] - ia[0] + 1
    }

    return nums.last() + 1 + k - cnt - 1
}


/**
 * binary search
 * O(lgN)
 */
fun missingElement(nums: IntArray, k: Int): Int {
    var l = 0
    var r = nums.size - 1

    while (l < r) {

        val m = (l + r) / 2

        if (m == nums.size - 1 || nums[m + 1] - nums[0] - 1 - m >= k) r = m
        else l = m + 1
    }

    return nums[l] + k - (nums[l] - nums[0] - 1 - (l - 1))
}