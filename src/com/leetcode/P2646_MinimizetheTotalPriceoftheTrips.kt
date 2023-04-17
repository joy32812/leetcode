/**
 * Tree dp.
 */
fun minimumTotalPrice(n: Int, edges: Array<IntArray>, price: IntArray, trips: Array<IntArray>): Int {

    fun getEdgeMap(): Map<Int, List<Int>> {
        val edgeMap = mutableMapOf<Int, MutableList<Int>>()

        for (edge in edges) {
            val (a, b) = edge

            edgeMap.getOrPut(a) { mutableListOf() }.add(b)
            edgeMap.getOrPut(b) { mutableListOf() }.add(a)
        }

        return edgeMap
    }

    val edgeMap = getEdgeMap()

    fun getParents(): Map<Int, Int> {
        val parents = mutableMapOf<Int, Int>()

        fun dfs(node: Int, parent: Int) {
            parents[node] = parent

            val children = edgeMap[node] ?: return

            for (child in children) {
                if (child == parent) continue

                dfs(child, node)
            }
        }

        dfs(0, -1)

        return parents
    }

    val parents = getParents()

    fun getPathToRoot(x: Int): List<Int> {
        val path = mutableListOf<Int>()
        var node = x
        while (node != -1) {
            path.add(node)
            node = parents[node]!!
        }
        return path
    }

    fun getPathInTheTree(x: Int, y: Int): Set<Int> {
        val xPath = getPathToRoot(x)
        val yPath = getPathToRoot(y)
        val yPathSet = yPath.toSet()

        val firstCommonNode = xPath.first { it in yPathSet }

        val pathSet = ((xPath union yPath) - (xPath intersect yPath)).toMutableSet()
        pathSet += firstCommonNode

        return pathSet
    }

    val counts = Array(n) { 0 }

    for (trip in trips) {
        val (x, y) = trip
        val pathSet = getPathInTheTree(x, y)
        for (node in pathSet) {
            counts[node]++
        }
    }


    val dp = Array(n) { Array(2) { Int.MAX_VALUE } }

    fun work(root: Int, select: Int,  parent: Int): Int {
        if (dp[root][select] != Int.MAX_VALUE) return dp[root][select]

        var sum = if (select == 1) price[root] * counts[root] / 2 else price[root] * counts[root]

        val children = edgeMap[root] ?: return sum
        for (child in children) {
            if (child == parent) continue

            if (select == 1) {
                sum += work(child, 0, root)
            } else {
                sum += minOf(work(child, 0, root), work(child, 1, root))
            }
        }

        dp[root][select] = sum
        return sum
    }


    return minOf(work(0, 0, -1), work(0, 1, -1))
}
