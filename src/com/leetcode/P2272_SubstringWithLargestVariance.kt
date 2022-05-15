package com.leetcode

/**
 * Prefix sum
 */
fun largestVariance(s: String): Int {

    fun getAns(x: Char, y: Char): Int {
        if (x == y) return 0

        val nums = s.map {
            when (it) {
                x -> 1
                y -> -1
                else -> null
            }
        }.filterNotNull()

        fun getPrefixSum(list: List<Int>): List<Int> {
            val ans = mutableListOf<Int>()
            var sum = 0
            for (d in list) {
                sum += d
                if (sum <= 0) sum = 0
                ans += sum
            }
            return ans
        }

        val left = getPrefixSum(nums)
        val right = getPrefixSum(nums.reversed()).reversed()

        fun getM(i: Int, arr: List<Int>) = if (i !in arr.indices) 0 else arr[i]

        return nums.mapIndexed { i, d ->
            if (d != -1) 0
            else getM(i - 1, left) + getM(i + 1, right) - 1
        }.max() ?: 0
    }

    return s.toSet().flatMap { x -> s.toSet().map { y -> Pair(x, y) } }.map { getAns(it.first, it.second) }.max() ?: 0
}
fun main() {
    println(largestVariance("aababbb"))
}
