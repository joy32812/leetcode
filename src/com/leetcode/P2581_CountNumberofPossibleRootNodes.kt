/**
 * Rerooting.
 * Just reverse all the edges to the root.
 * 2 dfs.
 */
fun rootCount(edges: Array<IntArray>, guesses: Array<IntArray>, k: Int): Int {
    val n = edges.size + 1

    fun toEdgeMap(edges: Array<IntArray>): MutableMap<Int, MutableList<Int>> {
        val edgeMap = mutableMapOf<Int, MutableList<Int>>()
        for ((u, v) in edges) {
            edgeMap.getOrPut(u) { mutableListOf() }.add(v)
            edgeMap.getOrPut(v) { mutableListOf() }.add(u)
        }
        return edgeMap
    }

    fun toKey(u: Int, v: Int) = 1L * u * 10000000 + v

    val edgeMap = toEdgeMap(edges)

    val noSet = guesses.map { toKey(it[0], it[1]) }.toMutableSet()
    val yesSet = mutableSetOf<Long>()

    val fathers = IntArray(n) { -1 }
    var sum = 0

    fun dfs(u: Int, father: Int) {
        fathers[u] = father

        val key = toKey(father, u)
        if (key in noSet) {
            noSet.remove(key)
            yesSet.add(key)
            sum ++
        }

        val es = edgeMap[u] ?: return
        for (v in es) {
            if (v != u && v != father) {
                dfs(v, u)
            }
        }
    }

    dfs(0, -1)

    var ans = 0

    fun work(u: Int, father: Int, su: Int) {
        val key = toKey(father, u)
        var tmpSu = su
        if (key in yesSet) {
            tmpSu --
        }

        val reverseKey = toKey(u, father)
        if (reverseKey in noSet) {
            tmpSu ++
        }

        if (tmpSu >= k) {
            ans ++
        }

        val es = edgeMap[u] ?: return
        for (v in es) {
            if (v != u && v != father) {
                work(v, u, tmpSu)
            }
        }

    }

    work(0, -1, sum)

    return ans
}
