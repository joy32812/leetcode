package com.leetcode

fun rotatedDigits(N: Int): Int {
    val numMap = mapOf(
            0 to 0,
            1 to 1,
            2 to 5,
            5 to 2,
            6 to 9,
            8 to 8,
            9 to 6
    )

    fun isGood(x: Int): Boolean {
        ("" + x).forEach {
            if (!numMap.containsKey(it - '0')) return false
        }

        return ("" + x).map { numMap[it - '0'] }.joinToString(separator = "").toInt() != x
    }

    return (1..N).filter { isGood(it) }.count()
}