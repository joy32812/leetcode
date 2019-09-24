package com.leetcode


fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {

    val edgeMap = mutableMapOf<Int, HashSet<Int>>()
    for (con in connections) {
        val (s, t) = con
        val sSet= edgeMap.computeIfAbsent(s) { HashSet() }
        sSet.add(t)

        val tSet= edgeMap.computeIfAbsent(t) { HashSet() }
        tSet.add(s)
    }


    val visit = BooleanArray(n) {false}
    val dis = IntArray(n) {-1}
    val low = IntArray(n) {-1}
    val parent = IntArray(n) {-1}

    var time = 0

    val ans = mutableListOf<List<Int>>()

    fun dfs(u: Int) {
        visit[u] = true

        time ++
        dis[u] = time
        low[u] = time

        val adjSet = edgeMap.computeIfAbsent(u) {HashSet()}
        for (v in adjSet) {
            if (!visit[v]) {

                parent[v] = u
                dfs(v)

                low[u] = Math.min(low[u], low[v])

                if (low[v] > dis[u]) ans.add(listOf(u, v))

            } else if (v != parent[u]){
                low[u] = Math.min(low[u], dis[v])
            }
        }

    }



    for (i in 0 until n) {
        if (!visit[i]) dfs(i)
    }

    return ans
}


fun main() {
    println(criticalConnections(5, listOf(
            listOf(1, 0),
            listOf(2, 0),
            listOf(3, 2),
            listOf(4, 2),
            listOf(4, 3),
            listOf(3, 0),
            listOf(4, 0)
    )))

}
