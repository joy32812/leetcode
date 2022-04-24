package com.leetcode

/**
 * Sort
 */
fun countRectangles(rectangles: Array<IntArray>, points: Array<IntArray>): IntArray {
    rectangles.sortByDescending { it[0] }

    class PointWithIndex(val p: IntArray, val id: Int)
    val pointsWithIndex = points.mapIndexed { idx, p -> PointWithIndex(p, idx) }.sortedByDescending { it.p[0] }

    val ans = Array(points.size) { 0 }
    var z = 0

    val heights = Array(101) { 0 }

    for (i in pointsWithIndex.indices) {
        val (x, y) = pointsWithIndex[i].p

        while (z < rectangles.size && rectangles[z][0] >= x) {
            val (_, y1) = rectangles[z]
            heights[y1]++
            z++
        }

        ans[pointsWithIndex[i].id] = (y..100).sumBy { heights[it] }
    }

    return ans.toIntArray()
}
