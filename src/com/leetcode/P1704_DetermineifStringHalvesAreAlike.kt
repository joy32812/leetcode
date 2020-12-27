package com.leetcode

/**
 * easy
 */
fun halvesAreAlike(s: String): Boolean {
    val half = s.length / 2
    val a = s.substring(0 until half).filter { it in "aeiouAEIOU" }
    val b = s.substring(half).filter { it in "aeiouAEIOU" }

    return a.length == b.length
}

fun main() {
    println("Hello")
}
