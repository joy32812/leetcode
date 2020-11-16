package com.leetcode

/**
 * prefix sum map
 */
fun minOperations(nums: IntArray, x: Int): Int {

    var sumMap = mutableMapOf<Int, Int>()
    var sum = 0
    for (i in nums.size - 1 downTo 0) {
        sum += nums[i]
        sumMap[sum] = nums.size - i
    }

    var ans = Int.MAX_VALUE
    if (x in sumMap) ans = sumMap[x]!!

    sum = 0
    for (i in nums.indices) {
        sum += nums[i]
        if (sum == x) ans = Math.min(ans, i + 1)
        if ((x - sum) in sumMap) {
            val rightSize = sumMap[x - sum]!!
            if (i + 1 + rightSize <= nums.size) {
                ans = Math.min(ans, i + 1 + rightSize)
            }
        }
    }

    return if (ans == Int.MAX_VALUE) -1 else ans
}

fun main() {
    println(minOperations(intArrayOf(1, 1), 3))
}

