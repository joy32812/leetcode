package com.leetcode

import java.util.TreeMap

/**
 * TreeMap
 * interval merge
 */
class CountIntervals() {
    val map = TreeMap<Int, Int>()
    var sum = 0L


    fun add(left: Int, right: Int) {
        var l = left
        var r = right

        fun intersect(l1: Int, r1: Int, l2: Int, r2: Int) = !(l1 > r2 || l2 > r1)

        fun merge(k: Int, v: Int) {
            if (!intersect(l, r, k, v)) return

            map.remove(k)
            sum -= v - k + 1

            l = minOf(l, k)
            r = maxOf(r, v)
        }


        while (true) {
            val floor = map.floorEntry(l) ?: break
            merge(floor.key, floor.value)
        }

        while (true) {
            val ceil = map.ceilingEntry(l) ?: break
            merge(ceil.key, ceil.value)
        }

        map[l] = r
        sum += r - l + 1
    }

    fun count(): Int {
        return sum.toInt()
    }

}

