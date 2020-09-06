package com.leetcode

/**
 * union find
 */
fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {

    fun removeBoth(): Int {
        val father = Array(n + 1) {0};
        for (i in 1..n) father[i] = i
        val nowEdges = edges.filter { it[0] == 3 }

        fun getFather(x: Int): Int {
            if (father[x] == x) return x
            father[x] = getFather(father[x])
            return father[x]
        }

        var ans = 0
        for (e in nowEdges) {
            val u = e[1]
            val v = e[2]

            val fu = getFather(u)
            val fv = getFather(v)

            if (fu == fv) ans++
            else {
                father[fu] = fv
            }
        }

        return ans
    }

    fun remove(type: Int): Int {
        val father = Array(n + 1) {0}
        for (i in 1..n) father[i] = i
        val nowEdges = edges.filter { it[0] == 3 || it[0] == type }

        fun getFather(x: Int): Int {
            if (father[x] == x) return x
            father[x] = getFather(father[x])
            return father[x]
        }

        var ans = 0
        for (e in nowEdges) {
            val u = e[1]
            val v = e[2]

            val fu = getFather(u)
            val fv = getFather(v)

            if (fu == fv) ans++
            else {
                father[fu] = fv
            }
        }

        val fa = getFather(1)
        for (i in 1..n) {
            if (fa != getFather(i)) return -1
        }

        return ans
    }

    edges.sortByDescending { it[0] }

    val ans1 = remove(1)
    val ans2 = remove(2)

    if (ans1 == -1 || ans2 == -1) return -1

    return ans1 + ans2 - removeBoth()

}

fun main() {
    println(maxNumEdgesToRemove(4, arrayOf(intArrayOf(3, 1, 2), intArrayOf(3, 2, 3), intArrayOf(1, 1, 3), intArrayOf(1, 2, 4), intArrayOf(1, 1, 2), intArrayOf(2, 3, 4))))
}
