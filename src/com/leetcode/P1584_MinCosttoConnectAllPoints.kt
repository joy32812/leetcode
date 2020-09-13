package com.leetcode

/**
 * MST
 */
fun minCostConnectPoints(points: Array<IntArray>): Int {
    val edges = mutableListOf<Pair<Int, Int>>()
    for (i in points.indices) {
        for (j in i + 1 until points.size) {
            edges += Pair(i, j);
        }
    }

    edges.sortBy { Math.abs(points[it.first][0] - points[it.second][0]) + Math.abs(points[it.first][1] - points[it.second][1]) }


    val father = Array(points.size) {-1}
    father.indices.map { father[it] = it }

    fun getFather(x: Int): Int {
        if (father[x] == x) return x
        father[x] = getFather(father[x])
        return father[x]
    }

    var cnt = 0
    var ans = 0
    for (e in edges) {
        val (u, v) = e

        val fu = getFather(u)
        val fv = getFather(v)
        if (fu == fv) continue
        father[fu] = fv

        ans += Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1])
        cnt ++
        if (cnt == points.size - 1) break
    }

    return ans
}

fun main() {
    println(minCostConnectPoints(
            arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(2, 2),
                    intArrayOf(3, 10),
                    intArrayOf(5, 2),
                    intArrayOf(7, 0)

            )
    ))
}
