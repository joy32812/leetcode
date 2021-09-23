package com.leetcode

/**
 * easy
 */
fun sumOfBeauties(nums: IntArray): Int {
    val n = nums.size
    val left = Array(n) { false }
    val right = Array(n) { false }


    var now = nums[0]
    for (i in 1 until n) {
        left[i] = nums[i] > now
        now = Math.max(now, nums[i])
    }

    now = nums[n - 1]
    for (i in n - 1 downTo 0) {
        right[i] = nums[i] < now
        now = Math.min(now, nums[i])
    }

    return (1 until n - 1).map {
        if (left[it] && right[it]) 2
        else if (nums[it - 1] < nums[it] && nums[it] < nums[it + 1]) 1
        else 0
    }.sum()

}

fun main() {
    println(sumOfBeauties(intArrayOf(2, 4, 6, 4)))
}
