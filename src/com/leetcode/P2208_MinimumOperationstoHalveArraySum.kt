package com.leetcode

import java.util.*

/**
 * PriorityQueue
 */
fun halveArray(nums: IntArray): Int {

    var sum = nums.map { it.toDouble() }.sum()
    var total = 0.0
    var ans = 0

    val pq = PriorityQueue<Double> { x, y ->
        if (x < y) 1
        else if (x == y) 0
        else -1
    }
    nums.forEach { pq.add(it.toDouble()) }

    while (2 * total < sum) {
        val top = pq.poll()

        total += top / 2
        pq.add(top / 2)

        ans ++
    }

    return ans
}
