package com.leetcode

/**
 * key: n is odd
 */
fun decode(encoded: IntArray): IntArray {
    val n = encoded.size + 1

    var first = encoded[0]
    var last = encoded[0]
    for (i in 1 until encoded.size) {
        last = last xor encoded[i]
        first = first xor last
    }

    (1..n).forEach { first = first xor it }

    val ans = mutableListOf(first)

    for (d in encoded) ans += (d xor ans.last())

    return ans.toIntArray()
}
