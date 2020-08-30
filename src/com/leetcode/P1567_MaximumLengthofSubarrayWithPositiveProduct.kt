package com.leetcode

/**
 * separate by zero
 * find out max for each subarray
 * check first and last negative position in each subarry
 */
fun getMaxLen(nums: IntArray): Int {
    var ans = 0
    var last = 0
    for (i in nums.indices) {
        if (nums[i] == 0) {
            ans = Math.max(ans, work(nums, last, i - 1));
            last = i + 1
        }

        if (i == nums.size - 1) {
            ans = Math.max(ans, work(nums, last, i));
            last = i + 1
        }
    }

    return ans
}

fun work(nums: IntArray, s: Int, t: Int): Int {
    if (s > t) return 0
    val negaList = mutableListOf<Int>()

    for (i in s..t) {
        if (nums[i] < 0) {
            negaList += i
        }
    }

    val size = t - s + 1
    if (negaList.size % 2 == 0) return size
    return Math.max(t - negaList.first(), negaList.last() - s)
}


fun main() {
    println(getMaxLen(intArrayOf(0,1,-2,-3,-4)))
}
