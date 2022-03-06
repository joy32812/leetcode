package com.leetcode

/**
 * memo dfs
 */
fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {

    val fathers = mutableMapOf<Int, MutableSet<Int>>()
    for ((s, t) in edges) {
        fathers.getOrPut(t) { mutableSetOf() } += s
    }

    val ans = mutableMapOf<Int, Set<Int>>()
    fun getAn(d: Int): Set<Int>{
        if (d in ans) return ans[d]!!

        val fs = fathers[d] ?: mutableListOf<Int>()
        val result = mutableSetOf<Int>()
        for (f in fs) {
            result.add(f)
            result.addAll(getAn(f))
        }

        ans[d] = result
        return result
    }


    return (0 until n).map { getAn(it).sorted() }
}


