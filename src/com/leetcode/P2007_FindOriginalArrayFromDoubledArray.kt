package com.leetcode

import java.util.*

/**
 * Remove the smallest one by one.
 */
fun findOriginalArray(changed: IntArray): IntArray {

    val treeMap = TreeMap<Int, Int>()
    changed.forEach { treeMap[it] = (treeMap[it] ?: 0) + 1 }

    val ans = mutableListOf<Int>()

    if (0 in treeMap) {
        val cnt = treeMap[0] ?: 0
        if (cnt % 2 == 1) return intArrayOf()
        repeat(cnt / 2) { ans += 0 }
        treeMap.remove(0)
    }

    while (treeMap.isNotEmpty()) {
        val (key, value) = treeMap.firstEntry()
        if ((treeMap[2 * key] ?: 0) < value) return intArrayOf()

        repeat(value) { ans += key }
        treeMap.remove(key)

        treeMap[2 * key] = (treeMap[2 * key] ?: 0) - value
        if (treeMap[2 * key] == 0) treeMap.remove(2 * key)
    }

    return ans.toIntArray()
}

