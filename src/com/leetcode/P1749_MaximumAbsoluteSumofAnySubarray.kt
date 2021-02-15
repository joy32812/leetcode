package com.leetcode

import kotlin.math.abs
import kotlin.math.max

/**
 * prefix sum
 */
fun maxAbsoluteSum(nums: IntArray): Int {

    var ans = 0
    var pre = 0
    for (d in nums) {
        pre += d
        ans = max(ans, pre)
        if (pre < 0) pre = 0
    }

    pre = 0
    for (d in nums) {
        pre += d
        ans = max(ans, abs(pre))
        if (pre > 0) pre = 0
    }
    return ans
}

fun main() {
    
}

