/**
 * 1. use union-find to divide the graph into several connected components.
 * 2. for each connected component, find the circle.
 * 3. for each node, it will drop into a circle eventually. So we can use dfs to find the answer.
 */
fun countVisitedNodes(edges: List<Int>): IntArray {
    val ans = IntArray(edges.size) { -1 }
    val n = edges.size
    val fathers = IntArray(n) { -1 }

    fun getFather(x: Int) : Int {
        if (fathers[x] == -1) return x
        fathers[x] = getFather(fathers[x])
        return fathers[x]
    }

    for (i in 0 until n) {
        val j = edges[i]
        val fi = getFather(i)
        val fj = getFather(j)
        if (fi != fj) {
            fathers[fi] = fj
        }
    }

    fun getCircle(from: Int): Set<Int> {
        var now = from
        val visited = mutableSetOf(from)
        var first = -1

        while (true) {
            val next = edges[now]
            if (next in visited) {
                first = next
                break
            }
            visited += next
        }

        val circle = mutableSetOf(first)
        now = first
        while (true) {
            val next = edges[now]
            if (next == first) break
            circle += next
            now = next
        }

        return circle
    }

    val visitedFatherSet = mutableSetOf<Int>()
    for (i in 0 until n) {
        val fi = getFather(i)
        if (fi !in visitedFatherSet) {
            val circle = getCircle(fi)
            for (j in circle) {
                ans[j] = circle.size
            }
            visitedFatherSet += fi
        }
    }

    fun dfs(u: Int): Int {
        if (ans[u] != -1) return ans[u]
        ans[u] = dfs(edges[u]) + 1
        return ans[u]
    }

    for (i in 0 until n) {
        if (ans[i] == -1) dfs(i)
    }

    return ans
}
