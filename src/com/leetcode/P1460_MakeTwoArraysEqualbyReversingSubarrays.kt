package com.leetcode

fun main() {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        target.sort()
        arr.sort()
        return target.contentEquals(arr)
    }
}
