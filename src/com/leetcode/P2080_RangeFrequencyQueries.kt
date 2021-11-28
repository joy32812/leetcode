package com.leetcode

/**
 * Binary search.
 */
class RangeFreqQuery(arr: IntArray) {

    val indMap = mutableMapOf<Int, MutableList<Int>>()

    init {
        for (i in arr.indices) {
            indMap.getOrPut(arr[i]) { mutableListOf() } += i
        }
    }

    fun bs(list: List<Int>, v: Int): Int {
        if (v < list.first()) return 0

        var l = 0
        var r = list.size

        while (l < r) {
            val m = (l + r) / 2

            if (list[m] >= v) r = m
            else l = m + 1
        }

        return l
    }

    fun query(left: Int, right: Int, value: Int): Int {
        if (value !in indMap) return 0
        return bs(indMap[value]!!, right + 1) - bs(indMap[value]!!, left)
    }

}
