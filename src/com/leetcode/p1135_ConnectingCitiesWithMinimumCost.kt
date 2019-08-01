package com.leetcode



fun minimumCost(N: Int, connections: Array<IntArray>): Int {


    var father = mutableMapOf<Int, Int>()
    for (i in 1..N) father[i] = i

    var ans = 0

    connections.sortBy { it[2] }
    connections.forEach {
        val x = it[0]
        val y = it[1]
        val v = it[2]


        val fatherX = getFather(father, x);
        val fatherY = getFather(father, y);

        if (fatherX != fatherY) {
            ans += v
            father[fatherY] = fatherX
        }
    }

    for (i in 1..N) father[i] = getFather(father, i)
    if (father.values.toSet().size == 1) return ans

    return -1
}

private fun getFather(father: MutableMap<Int, Int>, x: Int): Int = if (father[x] == x) x else getFather(father, father[x]!!)


fun main() {



}