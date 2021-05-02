package com.leetcode

import java.util.*


/**
 * Priority Queue
 */
fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
    var i = 0
    intervals.sortBy { it[0] }

    val ansMap = mutableMapOf<Int, Int>()
    val treeMap = TreeMap<Int, Int>()

    for (q in queries.sorted()) {
        while (i < intervals.size && intervals[i][0] <= q) {
            val (l, r) = intervals[i]
            treeMap[r - l + 1] = r
            i ++
        }

        while (treeMap.isNotEmpty() && treeMap.firstEntry().value < q) treeMap.pollFirstEntry()
        ansMap[q] = if (treeMap.isEmpty()) -1 else treeMap.firstKey()
    }

    return queries.map { ansMap[it]!! }.toIntArray()
}


/**
 * Segment tree
 */
fun minInterval2(intervals: Array<IntArray>, queries: IntArray): IntArray {

    class SEG(var num: Int, val left: SEG?, val right: SEG?, val l: Int, val r: Int)

    fun build(l: Int, r: Int): SEG {
        if (l == r) return SEG(Int.MAX_VALUE, null, null, l, r)
        val m = (l + r) / 2

        val left = build(l, m)
        val right = build(m + 1, r)
        return SEG(Int.MAX_VALUE, left, right, l, r)
    }

    fun update(ll: Int, rr: Int, num: Int, root: SEG) {
        val l = root.l
        val r = root.r

        if (l == ll && r == rr) {
            root.num = Math.min(root.num, num)
            return
        }

        val m = (l + r) / 2

        if (rr <= m) {
            update(ll, rr, num, root.left!!)
        } else if (ll > m) {
            update(ll, rr, num, root.right!!)
        } else {
            update(ll, m, num, root.left!!)
            update(m + 1, rr, num, root.right!!)
        }
    }

    fun read(p: Int, root: SEG): Int {
        val l = root.l
        val r = root.r
        if (l == r) return root.num

        val m = (l + r) / 2

        return if (p <= m) Math.min(root.num, read(p, root.left!!)) else Math.min(root.num, read(p, root.right!!))
    }

    val set = mutableSetOf<Int>()
    val map = mutableMapOf<Int, Int>()
    intervals.forEach { set.add(it[0]); set.add(it[1]) }
    queries.forEach { set.add(it) }
    set.toList().sorted().forEachIndexed { index, i -> map[i] = index + 1 }


    val root = build(1, set.size + 1)

    intervals.forEach {
        val l = map[it[0]]!!
        val r = map[it[1]]!!
        update(l, r, it[1] - it[0] + 1, root)
    }

    return queries.map {
        val ans = read(map[it]!!, root)
        if (ans == Int.MAX_VALUE) -1 else ans
    }.toIntArray()

}
