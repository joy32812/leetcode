import java.util.LinkedList

/**
 * TopSort-like.
 */
fun minimumFuelCost(roads: Array<IntArray>, seats: Int): Long {
    val n = roads.size + 1
    val parents = Array(n) { -1 }

    val edgeMap = mutableMapOf<Int, MutableList<Int>>()
    for ((u, v) in roads) {
        edgeMap.getOrPut(u) { mutableListOf() }.add(v)
        edgeMap.getOrPut(v) { mutableListOf() }.add(u)
    }

    fun dfs(root: Int, p: Int) {
        parents[root] = p
        val children = edgeMap[root] ?: return
        for (v in children) {
            if (v != p) {
                dfs(v, root)
            }
        }
    }

    dfs(0, -1)

    val degree = Array(n) { 0 }
    for (i in 1 until n) degree[parents[i]]++

    var Q = LinkedList<Int>()
    for (i in 1 until n) {
        if (degree[i] == 0) Q.add(i)
    }

    val carCount = Array(n) { 0 }
    val seatCount = Array(n) { 0 }
    var ans = 0L

    while (Q.isNotEmpty()) {
        val tmpQ = LinkedList<Int>()

        for (u in Q) {
            val v = parents[u]

            seatCount[u] ++
            if (seatCount[u] == seats) {
                carCount[u]++
                seatCount[u] = 0
            }

            if (v == 0) {
                ans += carCount[u] + (if (seatCount[u] > 0) 1 else 0)
                continue
            }

            ans += carCount[u] + (if (seatCount[u] > 0) 1 else 0)

            carCount[v] += carCount[u]
            seatCount[v] += seatCount[u]
            while (seatCount[v] >= seats) {
                carCount[v]++
                seatCount[v] -= seats
            }

            degree[v]--
            if (degree[v] == 0) {
                tmpQ.add(v)
            }
        }

        Q = tmpQ
    }

    return ans
}
