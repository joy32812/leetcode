package com.leetcode

fun checkPowersOfThree(n: Int): Boolean {

    val power3 = Array(17) { 1 }
    for (i in 1 until power3.size) power3[i] = power3[i - 1] * 3

    var tmp = n

    for (i in 16 downTo 0) {
        if (tmp >= power3[i]) tmp -= power3[i]
    }

    return tmp == 0
}
