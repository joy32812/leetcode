package com.leetcode

/**
 * reverse fill
 */
fun getSmallestString(n: Int, k: Int): String {
    var K = k - n
    val chars = Array(n) { 'a' }

    for (i in chars.indices.reversed()) {
        if (K > 25) {
            K -= 25
            chars[i] = 'z'
        } else {
            chars[i] = ('a' + K)
            break
        }
    }

    return chars.joinToString("")
}

fun main() {
    println(getSmallestString(3, 27))
    println(getSmallestString(5, 73))
//    println("Hello")
}
