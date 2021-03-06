package com.leetcode

fun minSwaps(grid: Array<IntArray>): Int {
    fun trailingZeroNum(arr: IntArray) = arr.size - 1 - arr.indexOfLast { it == 1 }

    var ans = 0
    val list = grid.map { trailingZeroNum(it) }.toMutableList()
    while (list.size > 1) {
        val index = list.indexOfFirst { it >= list.size - 1 }
        if (index == -1) return -1

        ans += index
        list.removeAt(index)
    }
    return ans
}
