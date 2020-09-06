package com.leetcode

/**
 * n * m
 * iterate both arrays
 * use groupBy to get the number of d
 */
fun numTriplets(nums1: IntArray, nums2: IntArray): Int {

    fun tripletsNumbers(a: IntArray, b: IntArray): Int {
        var ans = 0
        val aGroup = a.groupBy { it }

        for (i in b.indices) {
            for (j in i+1 until b.size) {
                val prod = 1L * b[i] * b[j]
                val sqrt = Math.sqrt(prod.toDouble()).toLong()
                if (sqrt * sqrt == prod && sqrt.toInt() in aGroup) {
                    ans += aGroup[sqrt.toInt()]!!.size
                }
            }
        }

        return ans
    }

    return tripletsNumbers(nums1, nums2) + tripletsNumbers(nums2, nums1)
}

fun main() {
    println("HELLO");
    println(43024 * 99908);

    val a = intArrayOf(43024,99908)
}
