
class Node(
    var cnt: Int,
    val next: Array<Node?>
) {
    constructor() : this(0, Array(26) { null })
}

/**
 * Trie tree
 */
fun sumPrefixScores(words: Array<String>): IntArray {

    val root = Node()

    fun insert(s: String) {
        var cur = root
        for (c in s) {
            val idx = c - 'a'
            if (cur.next[idx] == null) {
                cur.next[idx] = Node()
            }
            cur = cur.next[idx]!!
            cur.cnt++
        }
    }

    words.forEach { insert(it) }


    fun find(s: String): Int {
        var ans = 0
        var cur = root
        for (c in s) {
            val idx = c - 'a'
            cur = cur.next[idx]!!
            ans += cur.cnt
        }
        return ans
    }

    return words.map { find(it) }.toIntArray()
}
