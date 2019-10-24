package com.leetcode


fun checkStraightLine(coordinates: Array<IntArray>): Boolean {

    if (coordinates.size == 2) return true

    val (x1, y1) = Pair(coordinates[1][0] - coordinates[0][0], coordinates[1][1] - coordinates[0][1])

    for (i in 2 until coordinates.size) {

        val (x2, y2) = Pair(coordinates[i][0] - coordinates[0][0], coordinates[i][1] - coordinates[0][1])

        if (x2 * y1 != x1 * y2) return false

    }
    return true
}


fun main() {

    println("hello1")

}
