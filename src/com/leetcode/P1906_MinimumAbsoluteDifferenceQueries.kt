package com.leetcode


/**
 * binary search
 * or presum
 */
fun minDifference(nums: IntArray, queries: Array<IntArray>): IntArray {

    val indexList = Array(101) { mutableListOf<Int>() }
    for (i in nums.indices) indexList[nums[i]].add(i)

    // first bigger or equal
    fun bs1(list: MutableList<Int>, x: Int): Int {
        var l = 0
        var r = list.size

        while (l < r) {
            val m = (l + r) / 2

            if (list[m] >= x) r = m
            else l = m + 1
        }
        return l
    }

    // first smaller or equal
    fun bs2(list: MutableList<Int>, x: Int): Int {
        var l = 0
        var r = list.size

        while (l < r) {
            val m = (l + r) / 2

            if (list[m] > x) r = m
            else l = m + 1
        }
        return l - 1
    }


    fun inTheRange(v: Int, l: Int, r: Int): Boolean {
        val list = indexList[v]
        if (list.isEmpty() || list[0] > r || list.last() < l) return false

        val left = bs1(list, l)
        val right = bs2(list, r)

        return left <= right
    }

    fun getAns(l: Int, r: Int): Int {
        val filter = (1..100).filter { inTheRange(it, l, r) }
        if (filter.size == 1) return -1
        return (1 until filter.size).map { filter[it] - filter[it - 1] }.min()!!
    }

    return queries.map { getAns(it[0], it[1]) }.toIntArray()


}
