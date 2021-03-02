package com.leetcode

fun minDays(n: Int): Int {
    val ansMap = mutableMapOf<Int, Int>()
    fun work(x: Int): Int {
        if (x <= 2) return x
        if (x in ansMap) return ansMap[x]!!

        val result = 1 + Math.min(x % 3 + work(x / 3), x % 2 + work(x / 2))
        ansMap[x] = result
        return result
    }

    return work(n)
}

fun main() {
    println(minDays(100))
}
