package com.leetcode

fun smallestCommonElement(mat: Array<IntArray>): Int {

    var uniqSet = mat[0].toMutableSet()
    for (i in 1 until mat.size) {

        val nowSet = mat[i].toSet()
        uniqSet.retainAll(nowSet)
    }

    if (uniqSet.size == 0) return -1
    return uniqSet.toSortedSet().first()!!
}
