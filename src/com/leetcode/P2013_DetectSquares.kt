package com.leetcode

class DetectSquares() {

    val countMap = mutableMapOf<String, Int>()
    val yAndXset = mutableMapOf<Int, MutableSet<Int>>()

    fun add(point: IntArray) {
        val key = "" + point[0] + "_" + point[1]
        countMap[key] = (countMap[key] ?: 0) + 1

        yAndXset.getOrPut(point[1]) { mutableSetOf() } += point[0]
    }

    fun getKey(x: Int, y: Int) = "" + x + "_" + y
    fun getCount(x: Int, y: Int) = countMap[getKey(x, y)] ?: 0
    fun getSqNumber(ax: Int, ay: Int, bx: Int, by: Int): Int {
        val L = bx - ax
        return getCount(ax, ay) * getCount(bx, by) * getCount(ax, ay + L) * getCount(bx, by + L) + getCount(ax, ay) * getCount(bx, by) * getCount(ax, ay - L) * getCount(bx, by - L)
    }

    fun count(point: IntArray): Int {
        val (x, y) = point
        val currentCount = getCount(x, y)
        countMap[getKey(x, y)] = 1

        var total = 0
        val xSet = yAndXset[y] ?: mutableSetOf()

        for (ax in xSet) {
            if (ax == x) continue
            val ay = y
            val akey = getKey(ax, ay)
            if (akey !in countMap) continue

            if (ax < x) total += getSqNumber(ax, ay, x, y)
            else total += getSqNumber(x, y, ax, ay)
        }

        countMap[getKey(x, y)] = currentCount

        return total
    }
}

fun main() {

    val d = DetectSquares();
    d.add(intArrayOf(3, 10))
    d.add(intArrayOf(11, 2))
    d.add(intArrayOf(3, 2))
    println(d.count(intArrayOf(11, 10)))


}
