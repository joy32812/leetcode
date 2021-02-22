package com.leetcode

fun minOperations2(boxes: String): IntArray {
    val balls = boxes.mapIndexed { index, c -> if (c == '1') index else -1 }.filter { it > -1 }
    return boxes.indices.map { pos -> balls.sumBy { Math.abs(it - pos) } }.toIntArray()
}
