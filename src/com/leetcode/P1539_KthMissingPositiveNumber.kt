package com.leetcode

fun findKthPositive(arr: IntArray, k: Int): Int {
    return (0..2000).toMutableSet().minus(arr.toList()).toList()[k]
}
