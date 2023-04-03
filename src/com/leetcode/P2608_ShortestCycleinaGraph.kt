import java.util.LinkedList

fun findShortestCycle(n: Int, edges: Array<IntArray>): Int {

    val edgeMap = mutableMapOf<Int, MutableList<Int>>()
    for ((u, v) in edges) {
        edgeMap.getOrPut(u) { mutableListOf() }.add(v)
        edgeMap.getOrPut(v) { mutableListOf() }.add(u)
    }

    val par = IntArray(n) { -1 }

    var ans = Int.MAX_VALUE

    fun work(x: Int) {

        val dist = IntArray(n) { Int.MAX_VALUE / 2 }
        dist[x] = 0

        val Q = LinkedList<Int>()
        Q.add(x)

        while (Q.isNotEmpty()) {
            val u = Q.poll()

            val vs = edgeMap[u] ?: mutableListOf()

            for (v in vs) {

                if (dist[v] == Int.MAX_VALUE / 2) {
                    dist[v] = dist[u] + 1
                    par[v] = u
                    Q.add(v)
                } else if (par[u] != v && par[v] != u) {
                    ans = minOf(ans, dist[u] + dist[v] + 1)
                }
            }
        }
    }


    for (i in 0 until n) {
        work(i)
    }


    if (ans == Int.MAX_VALUE) return -1

    return ans

}
