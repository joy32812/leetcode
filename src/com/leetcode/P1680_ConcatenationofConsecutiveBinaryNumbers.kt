package com.leetcode

/**
 * brute force
 */
fun concatenatedBinary(n: Int): Int {

    val MOD = 1_000_000_000 + 7
    var ans = 0

    fun compute(x: Int) {
        for (ch in x.toString(2)) {
            val now = if (ch == '1') 1 else 0
            ans = (ans * 2 + now) % MOD
        }
    }

    for (i in 1..n) {
        compute(i)
    }

    return ans
}

fun main() {
    println("Hello")
    println(concatenatedBinary(1))
    println(concatenatedBinary(3))
    println(concatenatedBinary(12))
    println(concatenatedBinary(100000))
}
