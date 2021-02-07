package com.leetcode

fun maximumScore(a: Int, b: Int, c: Int): Int {

    val data = mutableListOf(a, b, c)
    data.sort()
    var ans = 0
    while (data[0] + data[1] > data[2]) {
        ans ++
        data[0] --
        data[1] --
    }

    ans += Math.min(data[0] + data[1], data[2])
    return ans
}


fun main() {
    println("Hello")
}

