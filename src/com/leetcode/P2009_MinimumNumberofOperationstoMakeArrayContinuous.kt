package com.leetcode

/**
 * binary search.
 */
fun minOperations2(nums: IntArray): Int {

    val n = nums.size
    val uniqueNums = nums.toSet().toIntArray()
    uniqueNums.sort()

    fun bs(x: Int): Int {
        if (x >= uniqueNums.last()) return uniqueNums.size

        var l = 0
        var r = uniqueNums.size

        while (l < r) {
            val m = (l + r) / 2
            if (uniqueNums[m] > x) r = m
            else l = m + 1
        }
        return l
    }

    var ans = Int.MAX_VALUE
    for (i in uniqueNums.indices) {
        val next = bs(uniqueNums[i] + n - 1)

        ans = Math.min(ans, n - (next - i))
    }

    return ans
}

fun main() {
    println(minOperations2(intArrayOf(8,5,9,9,8,4)))
}

