package com.leetcode

import java.util.*

fun longestSubsequenceRepeatedK(s: String, k: Int): String {

    var ans = ""
    val Q = LinkedList<String>()
    Q.add("")

    fun isSub(next: String): Boolean {
        var i = 0
        var j = 0
        var repeat = 0
        while (i < s.length) {
            if (s[i] == next[j]) j ++
            if (j == next.length) {
                repeat ++
                if (repeat == k) return true
                j = 0
            }
            i ++
        }

        return false
    }

    while (Q.isNotEmpty()) {
        val size = Q.size
        for (i in 0 until size) {
            val now = Q.poll()

            for (i in 0..26) {
                val next = now + ('a' + i).toChar()
                if (isSub(next)) {
                    ans = next
                    Q.add(next)
                }
            }
        }
    }

    return ans
}
