
data class TrieNode(
    val children: Array<TrieNode?> = Array(26) { null },
    var isEnd: Boolean = false,
    var idx: Int = -1
)

fun minimumCost(target: String, words: Array<String>, costs: IntArray): Int {

    fun createTrieTree(): TrieNode {
        val root = TrieNode()
        for (i in words.indices) {
            val word = words[i]
            var node = root
            for (c in word) {
                val idx = c - 'a'
                if (node.children[idx] == null) {
                    node.children[idx] = TrieNode()
                }
                node = node.children[idx]!!
            }
            node.isEnd = true
            if (node.idx == -1 || costs[node.idx] > costs[i]) {
                node.idx = i
            }
        }
        return root
    }

    val n = target.length
    val dp = IntArray(n) { Int.MAX_VALUE }

    for (i in words.indices) {
        val word = words[i]
        if (target.startsWith(word)) {
            val len = word.length
            dp[len - 1] = minOf(dp[len - 1], costs[i])
        }
    }

    val root = createTrieTree()

    for (i in 0 until n) {
        if (dp[i] == Int.MAX_VALUE) continue
        var node = root

        for (j in i + 1 until n) {
            val idx = target[j] - 'a'
            if (node.children[idx] == null) break
            node = node.children[idx]!!
            if (node.isEnd) {
                dp[j] = minOf(dp[j], dp[i] + costs[node.idx])
            }
        }
    }


    return if (dp[n - 1] == Int.MAX_VALUE) -1 else dp[n - 1]
}
