package com.leetcode


/**
 * Group by
 */
fun maximumSum_1(nums: IntArray): Int {

    fun Int.toDigitalSum() = toString().toCharArray().map { it - '0' }.sum()

    val gb = nums.groupBy { it.toDigitalSum() }

    var ans = -1

    for (v in gb.values) {
        val tv = v.sortedDescending()
        if (tv.size >= 2) ans = maxOf(ans, tv[0] + tv[1])
    }

    return ans
}
