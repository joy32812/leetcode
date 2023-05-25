fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {

    fun getEdgeMap(edges: Array<IntArray>): Map<Int, MutableList<Int>> {
        val edgeMap = mutableMapOf<Int, MutableList<Int>>()
        for (edge in edges) {
            val (u, v) = edge
            edgeMap.getOrPut(u) { mutableListOf() }.add(v)
            edgeMap.getOrPut(v) { mutableListOf() }.add(u)
        }
        return edgeMap
    }

    fun getDegrees(edges: Array<IntArray>): IntArray {
        val degrees = IntArray(n) { 0 }
        for (edge in edges) {
            val (u, v) = edge
            degrees[u] ++
            degrees[v] ++
        }
        return degrees
    }

    val edgeMap = getEdgeMap(edges)
    val degrees = getDegrees(edges)


    val colors = IntArray(n) { -1 }
    val colorGroups = mutableMapOf<Int, MutableList<Int>>()

    fun dfs(x: Int, color: Int) {
        colors[x] = color
        colorGroups.getOrPut(color) { mutableListOf() }.add(x)

        val nexts = edgeMap[x] ?: return
        for (y in nexts) {
            if (colors[y] != -1) continue
            dfs(y, color)
        }
    }


    for (i in 0 until n) {
        if (colors[i] != -1) continue
        val color = colorGroups.size

        dfs(i, color)
    }

    fun checkComplete(points: List<Int>): Boolean {
        return points.all { degrees[it] == points.size - 1 }
    }

    return colorGroups.values.count { checkComplete(it) }
}
