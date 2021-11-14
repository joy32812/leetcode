package com.leetcode

/**
 * union find
 */
fun friendRequests(n: Int, restrictions: Array<IntArray>, requests: Array<IntArray>): BooleanArray {

    fun key(x: Int, y: Int) = "" + x + "_" + y
    val resSet = restrictions.map { if (it[0] < it[1]) key(it[0], it[1]) else key(it[1], it[0]) }.toSet()

    var father = Array(n) { -1 }.toMutableList()


    fun getFather(fs: MutableList<Int>, x: Int): Int {
        if (fs[x] == -1 || fs[x] == x) return x
        fs[x] = getFather(fs, fs[x])
        return fs[x]
    }


    fun check(u: Int, v: Int): Boolean {
        val x = Math.min(u, v)
        val y = Math.max(u, v)

        if (key(x, y) in resSet) return false

        val copyFather = father.toMutableList()

        val fx = getFather(copyFather, x)
        val fy = getFather(copyFather, y)
        copyFather[fx] = fy

        for ((a, b) in restrictions) {

            val fa = getFather(copyFather, a)
            val fb = getFather(copyFather, b)

            if (fa == fb) return false
        }

        father = copyFather
        return true
    }

    return requests.map { check(it[0], it[1]) }.toBooleanArray()
}
