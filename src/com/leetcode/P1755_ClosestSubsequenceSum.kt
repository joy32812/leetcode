package com.leetcode

/**
 * meet in the middle
 */
fun minAbsDifference(nums: IntArray, goal: Int): Int {
    val min = nums.filter { it < 0 }.sum()
    val max = nums.filter { it > 0 }.sum()

    if (goal <= min) return Math.abs(goal - min)
    if (goal >= max) return Math.abs(goal - max)
    if (nums.size == 1) return Math.abs(goal - nums[0])

    fun allSum(numList: List<Int>): List<Int> {
        val dp = mutableSetOf(numList[0])
        for (i in 1 until numList.size) {
            val tmpSet = mutableSetOf<Int>()
            for (d in dp) tmpSet += d + numList[i]
            dp += numList[i]
            dp.addAll(tmpSet)
        }
        return dp.toList()
    }

    val first = allSum(nums.filterIndexed { index, i -> index < nums.size / 2 })
    val second = allSum(nums.filterIndexed { index, i -> index >= nums.size / 2 }).sorted()

    var result = Math.min(
            first.map { Math.abs(goal - it) }.min()!!,
            second.map { Math.abs(goal - it) }.min()!!
    );

    fun binarySearch(firstNum: Int): Int {
        val expect = goal - firstNum

        var l = 0
        var r = second.size
        while (l < r) {
            val m = (l + r) / 2
            if (second[m] >= expect) r = m
            else l = m + 1
        }

        var ans = Int.MAX_VALUE
        if (l in second.indices) ans = Math.min(ans, Math.abs(second[l] - expect))
        if (l - 1 in second.indices) ans = Math.min(ans, Math.abs(second[l - 1] - expect))
        if (l + 1 in second.indices) ans = Math.min(ans, Math.abs(second[l + 1] - expect))

        return ans
    }


    return Math.min(result, first.map { binarySearch(it) }.min()!!)
}


fun main() {
    println(minAbsDifference(
            intArrayOf(-2362351,3321373,783393,6520910,-6645423,-3733332),
            -2305717
    ))
}

