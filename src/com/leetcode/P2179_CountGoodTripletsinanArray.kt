package com.leetcode


/**
 * Binary indexed tree.
 */
fun goodTriplets(nums1: IntArray, nums2: IntArray): Long {

    val BIT = Array(nums1.size + 5) { 0L }
    fun update(t: Int) {
        var x = t
        while (x < BIT.size) {
            BIT[x] ++
            x += x and -x
        }
    }

    fun get(t: Int): Long {
        var ans = 0L
        var x = t
        while (x > 0) {
            ans += BIT[x]
            x -= x and -x
        }
        return ans
    }


    val posMap2 = mutableMapOf<Int, Int>()
    for (i in nums2.indices) posMap2[nums2[i]] = i

    var ans = 0L
    for (i in nums1.indices) {
        val x = nums1[i]

        val p2 = posMap2[x]!!

        val A = get(p2 + 1)
        val B = i - A
        val C = p2 - A
        val D = nums1.size - i - 1 - C


        ans += A * D
        update(p2 + 1)
    }

    return ans
}
