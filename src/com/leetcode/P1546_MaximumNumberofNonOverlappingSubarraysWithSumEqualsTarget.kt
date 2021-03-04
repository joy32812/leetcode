package com.leetcode

fun maxNonOverlapping(nums: IntArray, target: Int): Int {
    val sumPos = mutableMapOf(0 to -1)
    var sum = 0
    var lastPos = -1
    var ans = 0
    for (i in nums.indices) {
        sum += nums[i]
        if (sum - target in sumPos && sumPos[sum - target]!! >= lastPos) {
            ans ++
            lastPos = i
        }
        sumPos[sum] = i
    }

    return ans
}
