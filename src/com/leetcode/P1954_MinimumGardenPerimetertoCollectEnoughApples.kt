package com.leetcode

/**
 * binary search
 */
fun minimumPerimeter(neededApples: Long): Long {

    val n = 90100
    fun getApples(x: Int) = 1L * x * (x + 1) * x * 4 + 1L * x * (x + 1) * 2

    var l = 1
    var r = n - 1

    while (l < r) {
        val m = (l + r) / 2
        if (getApples(m) >= neededApples) r = m
        else l = m + 1
    }

    return 1L * l * 8
}

fun main() {
    println(minimumPerimeter(1000000000))
    println(minimumPerimeter(929231262624585))
}
