package com.leetcode

/**
 * rotate image
 */
fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
    val n = mat.size

    fun rotate(cur: Array<IntArray>): Array<IntArray> {
        val result = Array(n) { Array(n) { 0 } }
        for (i in 0 until n) {
            for (j in 0 until n) {
                result[j][n - i - 1] = cur[i][j]
            }
        }
        return result.map { it.toIntArray() }.toTypedArray()
    }

    fun equal(a: Array<IntArray>, b: Array<IntArray>) = a.flatMap { it.toList() }.joinToString("_") == b.flatMap { it.toList() }.joinToString("_")
    return (0..3).any {
        var now = mat
        repeat(it) { now = rotate(now) }
        equal(now, target)
    }
}

fun main() {
    println(findRotation(
        arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 1)
        ),
        arrayOf(
            intArrayOf(1, 0), intArrayOf(1, 0)
        ),
    ))
    println("Hello")
}
