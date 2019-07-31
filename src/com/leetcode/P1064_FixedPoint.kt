package com.leetcode



fun fixedPoint(A: IntArray): Int {

     val index = A.withIndex().filter { it.index == it.value }.minBy { it.index }?.index

    return index ?: -1
}