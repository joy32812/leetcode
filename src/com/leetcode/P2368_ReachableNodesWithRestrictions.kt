import java.util.LinkedList

/**
 * BFS
 */
fun reachableNodes(n: Int, edges: Array<IntArray>, restricted: IntArray): Int {

    val restrictedSet = restricted.toSet()

    val edgeMap = mutableMapOf<Int, MutableList<Int>>()
    for ((u, v) in edges) {
        edgeMap.getOrPut(u) { mutableListOf() }.add(v)
        edgeMap.getOrPut(v) { mutableListOf() }.add(u)
    }

    val visited = BooleanArray(n)
    visited[0] = true

    val Q = LinkedList<Int>()
    Q += 0

    while (Q.isNotEmpty()) {
        val u = Q.poll()

        val neighbors = edgeMap[u] ?: mutableListOf()

        for (v in neighbors) {
            if (visited[v]) continue
            if (v in restrictedSet) continue
            visited[v] = true
            Q += v
        }
    }


    return visited.count { it }
}
