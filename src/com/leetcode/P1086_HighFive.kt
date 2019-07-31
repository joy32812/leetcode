package com.leetcode



fun highFive(items: Array<IntArray>): Array<IntArray> {

    val ans = arrayListOf<IntArray>()
    items.groupBy { it[0] }.forEach {
        val descending = it.value.map { it[1] }.sortedByDescending { it }
        val sum = descending.subList(0, 5).sum()
        ans.add(intArrayOf(it.key, sum / 5))

    }

    return ans.toTypedArray()
}