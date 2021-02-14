package com.leetcode

fun minTrioDegree(n: Int, edges: Array<IntArray>): Int {
    val edgeSet = Array(n + 1) { mutableSetOf<Int>() }
    edges.forEach {
        edgeSet[it[0]].add(it[1])
        edgeSet[it[1]].add(it[0])
    }

    var ans = Int.MAX_VALUE
    for (i in 1..n) {
        for (j in edgeSet[i]) {
            if (j <= i) continue

            val common = edgeSet[i] intersect edgeSet[j]
            for (k in common) {
                if (k <= j) continue

                ans = Math.min(ans, edgeSet[i].size + edgeSet[j].size + edgeSet[k].size - 6)
            }
        }
    }

    return if (ans == Int.MAX_VALUE) -1 else ans
}

