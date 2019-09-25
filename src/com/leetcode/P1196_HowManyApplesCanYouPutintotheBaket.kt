package com.leetcode


fun maxNumberOfApples(arr: IntArray): Int {

    arr.sort()
    var sum = 0
    for (i in arr.indices) {
        sum += arr[i]
        if (sum > 5000) return i
    }

    return arr.size
}
