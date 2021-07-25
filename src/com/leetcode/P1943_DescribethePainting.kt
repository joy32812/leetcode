package com.leetcode

/**
 * Sweep line
 */
fun splitPainting(segments: Array<IntArray>): List<List<Long>> {
    class Paint(val pos: Long, val color: Long, val flag: Long)
    val paints = mutableListOf<Paint>()

    for ((from, to, col) in segments) {
        paints += Paint(from.toLong(), col.toLong(), 1)
        paints += Paint(to.toLong(), col.toLong(), 0)
    }

    paints.sortWith(compareBy({ it.pos }, { it.flag }))

    val ans = mutableListOf<List<Long>>()

    var last = paints[0].pos
    var currentColor = paints[0].color

    for (i in 1 until paints.size) {
        val pos = paints[i].pos
        val color = paints[i].color
        val flag = paints[i].flag

        // start
        if (flag.toInt() == 1) {
            if (last == pos) {
                currentColor += color
            } else {
                if (currentColor > 0) ans += listOf(last, pos, currentColor)
                last = pos
                currentColor += color
            }
        } else {
            if (last != pos) {
                if (currentColor > 0) ans += listOf(last, pos, currentColor)
                last = pos
            }
            currentColor -= color
        }
    }

    return ans.toList()
}
