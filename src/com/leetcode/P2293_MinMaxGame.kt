package com.leetcode

/**
 * easy / map {}
 */
fun minMaxGame(nums: IntArray): Int {
    var list = nums.toList()
    while (list.size > 1) {
        list = (0 until list.size / 2).map { i ->
            if (i % 2 == 0) minOf(list[i * 2], list[i * 2 + 1])
            else maxOf(list[i * 2], list[i * 2 + 1])
        }
    }

    return list.first()
}
