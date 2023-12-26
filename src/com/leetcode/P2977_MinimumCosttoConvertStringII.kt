/**
 * TrieTree + DP + floyd
 */
fun minimumCost(source: String, target: String, original: Array<String>, changed: Array<String>, cost: IntArray): Long {
    val LIMIT = 100_000_000
    val str2id = (original + changed).toSet().sorted().withIndex().map { it.value to it.index }.toMap()

    fun getDisMap(): Array<IntArray> {
        val dis = Array(str2id.size) { IntArray(str2id.size) { LIMIT } }
        for (i in 0 until str2id.size) {
            dis[i][i] = 0
        }

        for (i in original.indices) {
            val a = str2id[original[i]]!!
            val b = str2id[changed[i]]!!
            val c = cost[i]
            dis[a][b] = minOf(dis[a][b], c)
        }

        // floyd
        for (k in 0 until str2id.size) {
            for (i in 0 until str2id.size) {
                for (j in 0 until str2id.size) {
                    dis[i][j] = minOf(dis[i][j], dis[i][k] + dis[k][j])
                }
            }
        }
        return dis
    }

    data class TrieNode(
        val children: MutableMap<Char, TrieNode> = mutableMapOf(),
        var isWord: Boolean = false
    )

    fun createTrieTree(): TrieNode {
        val root = TrieNode()
        for (s in original.toSet()) {
            var cur = root
            for (c in s) {
                if (cur.children[c] == null) {
                    cur.children[c] = TrieNode()
                }
                cur = cur.children[c]!!
            }
            cur.isWord = true
        }
        return root
    }

    val disMap = getDisMap()
    val trieTree = createTrieTree()


    val n = source.length
    val dp = LongArray(n) { Long.MAX_VALUE }

    for (i in -1 until n - 1) {
        val now = if (i == -1) 0 else dp[i]
        if (now == Long.MAX_VALUE) continue

        for (j in i + 1 until n) {
            if (source[j] != target[j]) break
            dp[j] = minOf(dp[j], now)
        }

        var cur = trieTree
        for (j in i + 1 until n) {
            val c = source[j]
            if (cur.children[c] == null) break
            cur = cur.children[c]!!
            if (cur.isWord) {
                val sSub = source.substring(i + 1, j + 1)
                val tSub = target.substring(i + 1, j + 1)

                if (sSub !in str2id || tSub !in str2id) continue

                val co = disMap[str2id[sSub]!!][str2id[tSub]!!]
                if (co >= LIMIT) continue

                dp[j] = minOf(dp[j], now + co)
            }
        }

    }

    return if (dp.last() == Long.MAX_VALUE) -1 else dp.last()
}
