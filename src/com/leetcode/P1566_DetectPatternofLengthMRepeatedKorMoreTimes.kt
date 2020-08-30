package com.leetcode

import java.lang.StringBuilder

/**
 * check num of matches
 * much better
 */
fun containsPattern2(arr: IntArray, m: Int, k: Int): Boolean {
    var cnt = 0
    for (i in 0 until arr.size - m) {
        if (arr[i] != arr[i + m]) cnt = 0 else cnt ++
        if (cnt == m * (k - 1)) return true;
    }

    return false;
}

/**
 * brute force
 */
fun containsPattern(arr: IntArray, m: Int, k: Int): Boolean {
    for (i in arr.indices) {
        if (okay(arr, m, k, i)) return true
    }

    return false
}

fun okay(arr: IntArray, m: Int, k: Int, p: Int): Boolean {
    val size = arr.size
    if (m * k > size - p) return false

    val sb = StringBuilder()
    for (i in p until p + m) sb.append("_" + arr[i]);
    var cnt = 1
    for (i in p + m until size step m) {
        val sb2 = StringBuilder()
        for (j in i until i + m) sb2.append("_" + arr[j]);
        if (!sb2.toString().equals(sb.toString())) return false
        cnt ++

        if (cnt >= k) return true
    }

    return true
}


fun main() {
    println(containsPattern(intArrayOf(1, 2, 1, 2, 1, 1, 1, 3), 2, 2));
//    println(containsPattern(intArrayOf(2,2,1,2,2,1,1,1,2,1), 2, 2))
}
