package com.leetcode


/**
 * Two points
 */
fun countPairs0(n: Int, edges: Array<IntArray>, queries: IntArray): IntArray {

    val cnts = Array(n + 1) { 0 }
    val sortedCnts = Array(n + 1) { 0 }

    val edgeMap = mutableMapOf<Int, MutableSet<Int>>()
    var shareMap = mutableMapOf<String, Int>()

    for ((s, e) in edges) {
        val (p, q) = if (s < e) Pair(s, e) else Pair(e, s)

        cnts[p] ++
        cnts[q] ++
        sortedCnts[p] ++
        sortedCnts[q] ++

        val key = "" + p + "_" + q
        edgeMap.getOrPut(p) { mutableSetOf() } += q
        shareMap[key] = 1 + (shareMap[key] ?: 0)
    }
    sortedCnts.sort()


    fun work(q: Int): Int {
        var total = 0

        var i = 1
        var j = n
        while (i < j) {
            if (sortedCnts[i] + sortedCnts[j] > q) {
                total += j - i
                j --
            } else i ++
        }

        for (i in 1..n) {
            for (j in (edgeMap[i] ?: setOf<Int>())) {
                val key = "" + i + "_" + j
                if (cnts[i] + cnts[j] > q && cnts[i] + cnts[j] - (shareMap[key] ?: 0) <= q) total --
            }
        }

        return total
    }

    return queries.map { work(it) }.toIntArray()
}


/*-------------BIT solution---------*/
fun countPairs(n: Int, edges: Array<IntArray>, queries: IntArray): IntArray {
    val degrees = Array(n + 1) { 0 }
    val adjMap = mutableMapOf<Int, MutableSet<Int>>()
    val edgeCounts = mutableMapOf<String, Int>()
    edges.forEach {
        degrees[it[0]]++
        degrees[it[1]]++

        val (a, b) = if (it[0] < it[1]) it else intArrayOf(it[1], it[0])
        val key = "" + a + "_" + b
        edgeCounts[key] = 1 + (edgeCounts[key] ?: 0)

        adjMap.getOrPut(a) { mutableSetOf() }.add(b)
    }

    val M = edges.size + 10
    var BIT = Array(M) { 0 }

    fun add(x: Int, d: Int) {
        if (x == 0) return

        var y = x
        while (y < M) {
            BIT[y] += d
            y += y and -y
        }
    }
    fun count(x: Int): Int {
        var d = x
        var ans = 0
        while (d > 0) {
            ans += BIT[d]
            d -= d and -d
        }
        return ans
    }

    val ansMap = mutableMapOf<Int, Int>()

    fun work() {
        BIT = Array(M) { 0 }
        for (i in 1..n) add(degrees[i], 1)
        for (i in 1..n) {
            add(degrees[i], -1)
            for (j in (adjMap[i] ?: setOf<Int>())) {
                add(degrees[j], -1)
                val key = "" + i + "_" + j
                add(degrees[j] - (edgeCounts[key] ?: 0), 1)
            }

            for (q in queries.toSet()) {
                val tmp =
                    if (q - degrees[i] < 0) n - i
                    else count(M - 1) - count(q - degrees[i])

                ansMap[q] = (ansMap[q] ?: 0) + tmp
            }

            for (j in (adjMap[i] ?: setOf<Int>())) {
                add(degrees[j], 1)
                val key = "" + i + "_" + j
                add(degrees[j] - (edgeCounts[key] ?: 0), -1)
            }
        }
    }

    work()
    return queries.map { ansMap[it]!! }.toIntArray()
}
