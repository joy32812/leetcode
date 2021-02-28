package com.leetcode

import java.util.*


/**
 * stack
 * iterate from back
 */
fun getCollisionTimes(cars: Array<IntArray>): DoubleArray {
    val MAX = 1000_000.0

    val stack = LinkedList<Int>()
    val ans = DoubleArray(cars.size) { MAX }
    for (i in cars.indices.reversed()) {
        val (pi, si) = cars[i]
        while (stack.isNotEmpty()) {
            val j = stack.peek()
            val (pj, sj) = cars[j]
            // if speed is less, or Collision time is bigger
            if (si <= sj || 1.0 * (pj - pi) / (si - sj) > ans[j]) stack.pop()
            else break
        }

        if (stack.isNotEmpty()) {
            val j = stack.peek()
            val (pj, sj) = cars[j]
            ans[i] = 1.0 * (pj - pi) / (si - sj)
        }
        stack.push(i)
    }

    return ans.map { if (it == MAX) -1.0 else it }.toDoubleArray()
}

fun main() {
    println(getCollisionTimes(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 1)
        )
    ).toList())
}
