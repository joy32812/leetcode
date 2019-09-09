package com.leetcode

fun maximumSum(arr: IntArray): Int {

    val L = IntArray(arr.size)
    val R = IntArray(arr.size)

    var now = 0
    for (i in arr.indices) {
        now += arr[i]
        L[i] = now
        if (now < 0) now = 0
    }

    now = 0
    for (i in arr.size - 1 downTo 0) {
        now += arr[i]
        R[i] = now
        if (now < 0) now = 0
    }


    var ans = Math.max(L.max()!!, R.max()!!)
    for (i in 1 until arr.size - 1) {
        ans = Math.max(ans, L[i - 1] + R[i + 1])
    }
    return ans
}



fun main() {
    println(maximumSum(intArrayOf(11,-10,-11,8,7,-6,9,4,11,6,5,0)))
    println(maximumSum(intArrayOf(1, -4, -5, -2, 5, 0, -1, 2)))
    println(maximumSum(intArrayOf(1, -2, 0, 3)))
    println(maximumSum(intArrayOf(1, -2, -2, 3)))
    println(maximumSum(intArrayOf(-1, -1, -1, -1)))
}