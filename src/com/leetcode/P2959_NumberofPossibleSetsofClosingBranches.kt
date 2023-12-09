/**
 * Mask + floyd-marshall
 */
fun numberOfSets(n: Int, maxDistance: Int, roads: Array<IntArray>): Int {
    val MAX = 1000000007

    fun okay(mask: Int): Boolean {
        val nodes = (0 until n).filter { mask and (1 shl it) != 0 }.toSet()
        if (nodes.size < 2) return true

        val dis = Array(n) { IntArray(n) { MAX } }
        for (i in nodes) dis[i][i] = 0

        for ((u, v, w) in roads) {
            if (u in nodes && v in nodes) {
                dis[u][v] = minOf(dis[u][v], w)
                dis[v][u] = minOf(dis[v][u], w)
            }
        }

        // floyd-marshall
        for (k in nodes) {
            for (i in nodes) {
                for (j in nodes) {
                    dis[i][j] = minOf(dis[i][j], dis[i][k] + dis[k][j])
                }
            }
        }

        for (i in nodes) {
            for (j in nodes) {
                if (dis[i][j] > maxDistance) {
                    return false
                }
            }
        }
        return true
    }

    return (0 until (1 shl n)).count { okay(it) }
}

