package com.leetcode

/**
 * bit mask
 */
fun countMaxOrSubsets(nums: IntArray): Int {

    val n = nums.size
    val maskNum = 1 shl n

    fun getBitOr(b: Int): Int {
        var ans = 0
        for (i in nums.indices) {
            if ((b and (1 shl i)) > 0) ans = ans or nums[i]
        }
        return ans
    }

    val ors = (1 until maskNum).map { getBitOr(it) }
    val max = ors.max()

    return ors.count { it == max }
}
