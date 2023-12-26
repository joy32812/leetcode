/**
 * Floyd
 */
fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {
    val LIMIT = 100_000_000

    val dis = Array(26) { IntArray(26) { LIMIT } }
    for (i in 0 until 26) {
        dis[i][i] = 0
    }

    for (i in original.indices) {
        val a = original[i] - 'a'
        val b = changed[i] - 'a'
        val c = cost[i]

        dis[a][b] = minOf(dis[a][b], c)
    }

    // floyd
    for (k in 0 until 26) {
        for (i in 0 until 26) {
            for (j in 0 until 26) {
                dis[i][j] = minOf(dis[i][j], dis[i][k] + dis[k][j])
            }
        }
    }

    var ans = 0L
    for (i in source.indices) {
        val a = source[i] - 'a'
        val b = target[i] - 'a'

        if (dis[a][b] == LIMIT) {
            return -1
        }

        ans += dis[a][b]
    }

    return ans
}
