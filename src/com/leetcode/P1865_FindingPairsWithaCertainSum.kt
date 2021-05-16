package com.leetcode

/**
 * easy. use Map for counting
 */
class FindSumPairs(nums1: IntArray, nums2: IntArray) {

    val aa = nums1
    val bb = nums2
    val cntMap = mutableMapOf<Int, Int>()

    init {
        nums2.forEach { cntMap[it] = (cntMap[it] ?: 0) + 1 }
    }

    fun add(index: Int, d: Int) {
        cntMap[bb[index]] = cntMap[bb[index]]!! - 1
        bb[index] = bb[index] + d
        cntMap[bb[index]] = (cntMap[bb[index]] ?: 0) + 1
    }

    fun count(tot: Int): Int {
        return aa.sumBy { cntMap[tot - it] ?: 0 }
    }

}
