package com.leetcode

fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
    return (0 until n).toSet().minus(edges.map { it[1] }.toSet()).toList()
}
