package com.leetcode

/**
 * brute-force.
 */
fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
    if (m * n != original.size) return arrayOf()

    val ans = mutableListOf<IntArray>()
    var i = 0
    while (i < original.size) {
        ans.add(original.copyOfRange(i, i + n))
        i += n
    }

    return ans.toTypedArray()
}
