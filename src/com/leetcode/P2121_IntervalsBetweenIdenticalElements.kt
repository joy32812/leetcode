package com.leetcode

/**
 * group by
 * left and right sum
 */
fun getDistances(arr: IntArray): LongArray {

    val ans = Array(arr.size) { 0L }
    val groupBy = arr.withIndex().groupBy { it.value }.mapValues { it.value.map { k -> k.index } }


    for (nums in groupBy.values) {
        var l = 0
        var left = 0L

        var r = nums.size
        var right = nums.map { 1L * it }.sum()

        for (i in nums) {
            ans[i] = 1L * i * l - 1L * left + right - 1L * i * r

            left += i
            l ++

            right -= i
            r --
        }
    }

    return ans.toLongArray()
}
