package com.leetcode

/**
 * Binary Search
 */
fun waysToSplit(nums: IntArray): Int {
    val MOD = 1_000_000_000 + 7L

    val prefixSum = mutableListOf<Int>()
    for (d in nums) {
        val last = if (prefixSum.isNotEmpty()) prefixSum.last() else 0
        prefixSum += last + d
    }

    fun bsLeft(left: Int, right: Int, goal: Int): Int {
        if (left >= prefixSum.size || prefixSum.last() < goal) return -1

        var l = left
        var r = right
        while (l < r) {
            val m = (l + r) / 2
            if (prefixSum[m] >= goal) r = m
            else l = m + 1
        }
        return l
    }

    fun bsRight(left: Int, right: Int, goal: Int): Int {
        if (left >= prefixSum.size || prefixSum.last() < goal) return -1

        var l = left
        var r = right
        while (l < r) {
            val m = (l + r) / 2
            if (prefixSum[m] > goal) r = m
            else l = m + 1
        }
        return l - 1
    }

    var ans = 0L
    for (i in nums.indices) {
        val left = bsLeft(i + 1, prefixSum.size - 1, prefixSum[i] * 2)
        val half = prefixSum[i] + (prefixSum.last() - prefixSum[i]) / 2
        val right = bsRight(i + 1, prefixSum.size - 1, half)

        if (left == -1 || right == -1 || left > right) continue
        ans = (ans + right - left + 1) % MOD
    }

    return ans.toInt()
}


fun main() {

    println(waysToSplit(intArrayOf(8892,2631,7212,1188,6580,1690,5950,7425,8787,4361,9849,4063,9496,9140,9986,1058,2734,6961,8855,2567,7683,4770,40,850,72,2285,9328,6794,8632,9163,3928,6962,6545,6920,926,8885,1570,4454,6876,7447,8264,3123,2980,7276,470,8736,3153,3924,3129,7136,1739,1354,661,1309,6231,9890,58,4623,3555,3100,3437)))
//    println(waysToSplit(intArrayOf(0, 0, 0)))
//    println(waysToSplit(intArrayOf(3, 2, 1)))
//    println(waysToSplit(intArrayOf(1, 1, 1)))
//    println(waysToSplit(intArrayOf(1, 2, 2, 2, 5, 0)))

}
