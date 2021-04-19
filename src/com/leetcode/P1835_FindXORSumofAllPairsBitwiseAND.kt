package com.leetcode

fun getXORSum(arr1: IntArray, arr2: IntArray): Int {

    val onesMap = (0..30).map { p -> p to arr1.count { (it and (1 shl p)) > 0 } }.toMap()

    return (0..30).map { p ->
        val cnt = arr2.count { (it and (1 shl p)) > 0 }
        val total = 1L * cnt * onesMap[p]!!
        if (total % 2 == 1L) "1" else "0"
    }.joinToString("").reversed().toInt(2)

}
