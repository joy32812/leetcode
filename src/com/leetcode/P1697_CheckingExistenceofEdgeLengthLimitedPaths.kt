package com.leetcode

/**
 * Union-find
 */
fun distanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
    class Query(val index: Int, val q: IntArray)
    val qList = queries.mapIndexed { index, q -> Query(index, q) }.sortedBy { it.q[2] }
    edgeList.sortBy { it[2] }

    val father = Array(n) { -1 }
    father.indices.map { father[it] = it }
    fun getFather(x: Int): Int {
        if (father[x] == x) return x
        father[x] = getFather(father[x])
        return father[x]
    }

    var l = 0
    val ans = Array(queries.size) { false }
    for (i in qList.indices) {
        while (l < edgeList.size && edgeList[l][2] < qList[i].q[2]) {
            val (u, v, _) = edgeList[l]
            val fu = getFather(u)
            val fv = getFather(v)
            father[fu] = fv
            l++
        }

        val (x, y, _) = qList[i].q
        ans[qList[i].index] = getFather(x) == getFather(y)
    }

   return ans.toBooleanArray()
}

fun main() {
    println(distanceLimitedPathsExist(5,
            arrayOf(
                    intArrayOf(0, 1, 10),
                    intArrayOf(1, 2, 5),
                    intArrayOf(2, 3, 9),
                    intArrayOf(3, 4, 13)
            ),
            arrayOf(
                    intArrayOf(0, 4, 14),
                    intArrayOf(1, 4, 13)
            )
    ))
}
