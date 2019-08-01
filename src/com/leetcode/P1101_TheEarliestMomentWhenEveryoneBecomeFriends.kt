package com.leetcode


fun earliestAcq(logs: Array<IntArray>, N: Int): Int {

    val father = mutableMapOf<Int, Int>()
    for (i in 0 until N) father[i] = i


    logs.sortBy { it[0] }

    logs.forEach {

        val t = it[0]
        val a = it[1]
        val b = it[2]


        val fa = getFather(father, a)
        val fb = getFather(father, b)

        if (fa != fb) {
            father[fa] = fb
        }

        for (i in 0 until N) father[i] = getFather(father, i)

        if (father.values.toSet().size == 1) return t

    }

    return -1

}

private fun getFather(father: MutableMap<Int, Int>, x: Int): Int = if (father[x] == x) x else getFather(father, father[x]!!)
