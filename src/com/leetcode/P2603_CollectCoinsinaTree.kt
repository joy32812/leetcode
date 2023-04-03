fun collectTheCoins(coins: IntArray, edges: Array<IntArray>): Int {

    val n = coins.size
    if (n <= 3) return 0

    val edgeMap = mutableMapOf<Int, MutableList<Int>>()
    val deg = IntArray(n)
    for (e in edges) {
        deg[e[0]]++
        deg[e[1]]++

        edgeMap.getOrPut(e[0]) { mutableListOf() }.add(e[1])
        edgeMap.getOrPut(e[1]) { mutableListOf() }.add(e[0])
    }

    val covers = Array(n) { 0 }
    val removeSet = mutableSetOf<Int>()

    var Q = (0 until n).filter { deg[it] <= 1 }

    while (Q.isNotEmpty()) {
        val tmpQ = mutableListOf<Int>()

        for (u in Q) {
            if (covers[u] >= 2) continue
            removeSet += u

            val vs = edgeMap[u] ?: continue

            for (v in vs) {
                if (v in removeSet) continue

                deg[v]--

                if (coins[u] == 1 || covers[u] == 1) {
                    covers[v] = maxOf(covers[v], covers[u] + 1)
                }

                if (deg[v] <= 1) tmpQ += v
            }
        }

        Q = tmpQ
    }

    if (removeSet.size == n) return 0

    return 2 * (n - 1 - removeSet.size)
}
