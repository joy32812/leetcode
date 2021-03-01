package com.leetcode

import java.util.*


fun findLatestStep(arr: IntArray, m: Int): Int {
    val n = arr.size

    val treeMap = TreeMap<Int, Int>()
    treeMap[1] = n
    if (m == n) return n

    for (i in arr.indices.reversed()) {
        val d = arr[i]
        val (l, r) = treeMap.floorEntry(d)
        treeMap.remove(l)

        if (d - l == m || r - d == m) return i
        if (d - l > 0) treeMap[l] = d - 1
        if (r - d > 0) treeMap[d + 1] = r
    }

    return -1
}
