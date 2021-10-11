package com.leetcode

import java.util.*

/**
 * Meet in the middle
 * +
 * binary search
 */
fun minimumDifference(nums: IntArray): Int {
    val sum = nums.sum()
    val n = nums.size
    val left = nums.toList().subList(0, n / 2)
    val right = nums.toList().subList(n / 2, n)


    fun getMaskSums(arr: List<Int>): MutableMap<Int, TreeSet<Int>> {
        var res = mutableMapOf<Int, TreeSet<Int>>()

        for (i in 0 until (1 shl n / 2)) {
            var sum = 0
            var cnt = 0
            for (j in arr.indices) {
                if ((i and (1 shl j)) > 0) {
                    sum += arr[j]
                    cnt ++
                }
            }
            res.getOrPut(cnt) { TreeSet() } += sum
        }
        return res
    }

    val leftRes = getMaskSums(left)
    val rightRes = getMaskSums(right)

    fun getMinDiff(l: Int): Int {
        val r = n / 2 - l
        var ans = Int.MAX_VALUE

        for (a in leftRes[l]!!) {
            val b = rightRes[r]!!
            val need = sum / 2 - a

            if (b.floor(need) != null) {
                ans = Math.min(ans, Math.abs(sum - 2 * a - 2 *b.floor(need)!!))
            }
            if (b.ceiling(need) != null) {
                ans = Math.min(ans, Math.abs(sum - 2 * a - 2 * b.ceiling(need)!!))
            }
        }

        return ans
    }

    return (0 .. n / 2).map { getMinDiff(it) }.min()!!
}

fun main() {
    println(minimumDifference(intArrayOf(3, 9, 7, 3)))
}
