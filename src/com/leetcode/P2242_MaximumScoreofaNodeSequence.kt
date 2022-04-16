package com.leetcode

/**
 * Pick one edge
 * find the top score neighbours
 */
fun maximumScore(scores: IntArray, edges: Array<IntArray>): Int {

    data class Node(val id: Int, val score: Int)

    val edgeMap = mutableMapOf<Int, MutableList<Node>>()
    for ((s, t) in edges) {
        edgeMap.getOrPut(s) { mutableListOf() } += Node(t, scores[t])
        edgeMap.getOrPut(t) { mutableListOf() } += Node(s, scores[s])
    }

    edgeMap.values.forEach { it.sortByDescending { it.score } }

    fun getTop3(list: List<Node>, s: Int, t: Int) = list.take(3).filter { it.id != s && it.id != t }

    var ans = -1
    for ((s, t) in edges) {
        val list1 = edgeMap[s] ?: mutableListOf()
        val list2 = edgeMap[t] ?: mutableListOf()

        if (list1.isEmpty() || list2.isEmpty()) continue

        val ss = getTop3(list1, s, t)
        val tt = getTop3(list2, s, t)
        if (ss.isEmpty() || tt.isEmpty()) continue

        val total =
            if (ss.first() != tt.first()) scores[s] + scores[t] + ss[0].score + tt[0].score
            else if (ss.size >= 2 && tt.size >= 2) scores[s] + scores[t] + ss[0].score + Math.max(
                ss[1].score,
                tt[1].score
            )
            else -1

        ans = Math.max(ans, total)
    }

    return ans
}
