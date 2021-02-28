package com.leetcode

/**
 * greedy
 */
fun minOperations2(nums1: IntArray, nums2: IntArray): Int {

    fun work(aa: IntArray, bb: IntArray): Int {
        val data = mutableListOf<Int>()
        data.addAll(aa.map { 6 - it }.filter { it != 0 })
        data.addAll(bb.map { it - 1 }.filter { it != 0 })
        data.sortDescending()

        var cnt = 0
        var sumDiff = bb.sum() - aa.sum()
        for (d in data) {
            if (sumDiff <= 0) break
            cnt ++
            sumDiff -= d
        }

        return if (sumDiff > 0) -1 else cnt
    }

    return if (nums1.sum() < nums2.sum()) work(nums1, nums2) else work(nums2, nums1)
}


fun main() {

    println(minOperations2(
        intArrayOf(1,2,3,4,5,6),
        intArrayOf(1,1,2,2,2,2)
    ))

}
