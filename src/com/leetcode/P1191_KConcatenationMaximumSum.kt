package com.leetcode


fun kConcatenationMaxSum(arr: IntArray, k: Int): Int {

    var nowList = mutableListOf<Int>()
    nowList.addAll(arr.toList())
    if (k >= 2) nowList.addAll(arr.toList())

    var ans = 0

    var now = 0
    for (i in nowList.indices) {
        now += nowList[i]
        if (now < 0) now = 0
        ans = Math.max(ans, now)
    }

    var minLeft = 0
    now = 0
    for (i in arr.indices) {
        now += arr[i]
        minLeft = Math.min(minLeft, now)
    }

    var minRight = 0
    now = 0
    for (i in arr.size - 1 downTo 0) {
        now += arr[i]
        minRight = Math.min(minRight, now)
    }



    val sum = arr.sum()

    val mod = 1_000_000_000 + 7L
    if (sum > 0 && 1L * sum * k - minLeft - minRight > ans) {
        ans = ((1L * sum * k - minLeft - minRight) % mod).toInt()
    }

    return ans
}


fun main() {
    println(kConcatenationMaxSum(intArrayOf(-5,-2,0,0,3,9,-2,-5,4), 5))
    println(kConcatenationMaxSum(intArrayOf(1, 2), 3))
    println(kConcatenationMaxSum(intArrayOf(1, -2, 1), 5))
    println(kConcatenationMaxSum(intArrayOf(-1, -2), 7))
}
