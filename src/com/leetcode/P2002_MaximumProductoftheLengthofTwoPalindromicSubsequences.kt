package com.leetcode

/**
 * binary mask
 */
fun maxProduct(s: String): Int {

    val n = s.length
    val total = (1 shl n) - 1

    fun getPalLength(t: String): Int {
        if (t.length <= 1) return t.length

        val map = mutableMapOf<String, Int>()
        fun dfs(l: Int, r: Int): Int {
            if (l > r) return 0
            if (l == r) return 1
            val key = "" + l + "_" + r
            if (key in map) return map[key]!!

            val tmp = if (t[l] == t[r]) 2 + dfs(l + 1, r - 1) else Math.max(dfs(l + 1, r), dfs(l, r - 1))
            map[key] = tmp
            return tmp
        }

        return dfs(0, t.length - 1)
    }

    fun work(x: Int): Int {
        val sa = s.filterIndexed { index, c -> ((1 shl index) and x) > 0 }
        val sb = s.filterIndexed { index, c -> ((1 shl index) and x) == 0 }

        return getPalLength(sa) * getPalLength(sb)
    }

    return (1 until total).map { work(it) }.max()!!
}
