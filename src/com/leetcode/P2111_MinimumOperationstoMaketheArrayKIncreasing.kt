package com.leetcode


/**
 * LIS
 */
fun kIncreasing(arr: IntArray, k: Int): Int {

    var ans = 0

    fun bs(dp: List<Int>, d: Int): Int {

        var l = 0
        var r = dp.size - 1

        while (l < r) {
            val m = (l + r) / 2
            if (dp[m] > d) r = m
            else l = m + 1
        }

        return l
    }

    fun lengthOfLIS(nums: List<Int>): Int {
        val dp = mutableListOf<Int>()
        for (d in nums) {
            if (dp.size == 0 || dp[dp.size - 1] <= d) {
                dp.add(d)
            } else {
                var i = bs(dp, d)
                dp[i] = d
            }
        }
        return dp.size
    }

    fun getAns(nums: List<Int>): Int {
        return nums.size - lengthOfLIS(nums)
    }

    for (i in 0 until k) {
        val nums = mutableListOf<Int>()
        var j = i
        while (j < arr.size) {
            nums += arr[j]
            j += k
        }

        ans += getAns(nums)
    }

    return ans
}

fun main() {
    println(kIncreasing(intArrayOf(2,2,2,2,2,1,1,4,4,3,3,3,3,3), 1))
}
