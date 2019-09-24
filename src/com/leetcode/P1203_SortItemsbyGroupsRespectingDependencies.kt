package com.leetcode

import java.util.*

fun sortItems(n: Int, m: Int, group: IntArray, beforeItems: List<List<Int>>): IntArray {

    val inDeg = Array(n) {0}
    val inGroup = Array(m) {0}

    val edgeMap = mutableMapOf<Int, HashSet<Int>>()

    val gy = group.withIndex().groupBy { it.value }.mapValues { it.value.map { it.index }.toMutableSet() }
    val groupEdgeMap = mutableMapOf<Int, HashSet<Int>>()


    for (i in beforeItems.indices) {
        for (j in beforeItems[i]) {
            inDeg[i] ++
            edgeMap.computeIfAbsent(j) {HashSet()}.add(i)

            if (group[i] == -1 || group[j] == -1 || group[i] == group[j]) continue
            val jSet = groupEdgeMap.computeIfAbsent(group[j]) {HashSet()}
            if (group[i] !in jSet) {
                jSet += group[i]
                inGroup[group[i]]++
            }
        }
    }

    val Q = LinkedList<Int>()
    for (i in 0 until n) {
        if (inDeg[i] == 0 && (group[i] == -1 || inGroup[group[i]] == 0)) {
            Q += i
        }
    }
    if (Q.isEmpty()) return intArrayOf()

    val ans = mutableListOf<Int>()

    while (!Q.isEmpty()) {
        val s = Q.poll()
        ans += s

        val g = group[s]
        val gSet = gy[g]!!
        gSet.remove(s)

        val candidateSet = mutableSetOf<Int>()

        if (g != -1 && gSet.isEmpty()) {
            val groupEdge = groupEdgeMap.computeIfAbsent(g) {HashSet()}
            for (gt in groupEdge) {
                inGroup[gt]--

                candidateSet.addAll(gy[gt]!!)
            }
        }


        val edge = edgeMap.computeIfAbsent(s) {HashSet()}
        for (t in edge) {
            inDeg[t] --

            if (inDeg[t] == 0) candidateSet.add(t)
        }


    }

    if (ans.size != n) return intArrayOf()
    return ans.toIntArray()
}

fun main() {

    println(sortItems(8, 3, intArrayOf(-1,-1,1,0,0,1,0,-1), listOf(
            listOf(),
            listOf(6),
            listOf(5),
            listOf(6),
            listOf(3, 6),
            listOf(),
            listOf(),
            listOf()
    )))
}
