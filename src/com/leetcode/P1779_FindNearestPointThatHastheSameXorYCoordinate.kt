package com.leetcode

fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {

    class Node(val index: Int, val x: Int, val y: Int)
    fun manhattan(nod: Node) = Math.abs(nod.x - x) + Math.abs(nod.y - y)
    val ans = points.mapIndexed { index, ints -> Node(index, ints[0], ints[1]) }.filter { it.x == x || it.y == y }
        .minWith(compareBy({ manhattan(it) }, { it.index }))

    return ans?.index ?: -1
}
