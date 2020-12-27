package com.leetcode

/**
 * Trie Tree
 */
fun maximizeXor(nums: IntArray, queries: Array<IntArray>): IntArray {
    nums.sort()

    class TrieNode(var theNum: Int, val next: Array<TrieNode?>)

    class IndexedQuery(val index: Int, val query: IntArray)
    val indexedQueries = queries.indices.map { IndexedQuery(it, queries[it]) }.sortedBy { it.query[1] }

    val root = TrieNode(-1, arrayOf(null, null))
    fun addToTrie(num: Int) {
        var head = root
        for (i in 30 downTo 0) {
            if (((1 shl i) and num) == 0) {
                if (head.next[0] == null) head.next[0] = TrieNode(-1, arrayOf(null, null))
                head = head.next[0]!!
            } else {
                if (head.next[1] == null) head.next[1] = TrieNode(-1, arrayOf(null, null))
                head = head.next[1]!!
            }
        }
        head.theNum = num
    }

    fun getMaxXOR(num: Int): Int {
        if (root.next[0] == null && root.next[1] == null) return -1

        var head = root
        for (i in 30 downTo 0) {
            if (((1 shl i) and num) == 0) {
                head = head.next[1] ?: head.next[0]!!
            }
            if (((1 shl i) and num) != 0) {
                head = head.next[0] ?: head.next[1]!!
            }
        }

        return head.theNum xor num
    }

    val ans = Array(queries.size) { -1 }
    var i = 0
    for (iq in indexedQueries) {
        while (i < nums.size && nums[i] <= iq.query[1]) {
            addToTrie(nums[i])
            i ++
        }

        ans[iq.index] = getMaxXOR(iq.query[0])
    }

    return ans.toIntArray()
}

fun main() {
    println(maximizeXor(
            intArrayOf(5, 2, 4, 6, 6, 3),
            arrayOf(
                    intArrayOf(12, 4),
                    intArrayOf(8, 1),
                    intArrayOf(6, 3)
            )
    ))
}
