package com.leetcode

fun checkWays(pairs: Array<IntArray>): Int {
    val edgeMap = mutableMapOf<Int, MutableSet<Int>>()
    for (pa in pairs) {
        edgeMap.getOrPut(pa[0]) { mutableSetOf() } += pa[1]
        edgeMap.getOrPut(pa[1]) { mutableSetOf() } += pa[0]
    }

    fun helper(nodes: Set<Int>): Int {
        val degreeMap = mutableMapOf<Int, MutableList<Int>>()
        for (node in nodes) {
            degreeMap.getOrPut(edgeMap[node]!!.size) { mutableListOf() } += node
        }

        if (nodes.size - 1 !in degreeMap) return 0

        val root = degreeMap[nodes.size - 1]!![0]
        for (child in edgeMap[root]!!) edgeMap[child]!! -= root

        val visited = mutableSetOf<Int>()
        val comp = mutableListOf<MutableSet<Int>>()
        fun dfs(nod: Int, index: Int) {
            if (nod in visited) return

            if (comp.size == index) comp.add(mutableSetOf())
            visited.add(nod)
            comp[index].add(nod)
            for (child in edgeMap[nod]!!) dfs(child, index)
        }

        for (node in nodes) {
            if (node == root) continue
            dfs(node, comp.size)
        }

        val results = comp.map { helper(it) }

        if (0 in results) return 0
        if (2 in results) return 2

        if (degreeMap[nodes.size - 1]!!.size > 1) return 2

        return 1
    }

    return helper(edgeMap.keys)
}


fun main() {

    println(checkWays(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )
    ))

}
