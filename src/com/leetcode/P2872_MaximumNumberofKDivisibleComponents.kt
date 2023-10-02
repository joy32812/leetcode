/**
 * Sum of sub-tree.
 * If sum % k == 0, means we can break the tree from this edge.
 */
fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
    val edgeMap = mutableMapOf<Int, MutableList<Int>>()
    for (edge in edges) {
        edgeMap.getOrPut(edge[0]) { mutableListOf() } += edge[1]
        edgeMap.getOrPut(edge[1]) { mutableListOf() } += edge[0]
    }

    var ans = 0
    fun dfs(node: Int, parent: Int): Long {
        var total = values[node].toLong()
        val children = edgeMap[node] ?: mutableListOf()

        for (child in children) {
            if (child == parent) continue
            val childTotal = dfs(child, node)
            total += childTotal
        }

        if (total % k == 0L) ans ++
        return total
    }

    dfs(0, -1)


    return ans
}
