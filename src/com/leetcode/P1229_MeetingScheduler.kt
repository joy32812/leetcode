package com.leetcode

import java.util.*

fun minAvailableDuration(slots1: Array<IntArray>, slots2: Array<IntArray>, duration: Int): List<Int> {

    val beginTimes = slots1.map { it[0] }.toSet().plus(slots2.map { it[0] }).toSortedSet()

    val treeMap1 = TreeMap<Int, Int>()
    slots1.forEach { treeMap1[it[0]] = it[1] }

    val treeMap2 = TreeMap<Int, Int>()
    slots2.forEach { treeMap2[it[0]] = it[1] }

    fun findFirst(s: Int): Pair<Int, Int>? {
        val floorEntry1 = treeMap1.floorEntry(s)
        val floorEntry2 = treeMap2.floorEntry(s)
        if (floorEntry1 == null || floorEntry2 == null) return null

        if (floorEntry1.value >= s + duration && floorEntry2.value >= s + duration) return Pair(s, s + duration)
        return null
    }

    for (s in beginTimes) {
        val ret = findFirst(s)
        if (ret != null) return listOf(ret.first, ret.second)
    }

    return listOf()
}
