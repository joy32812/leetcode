@file:JvmName("P1763_LongestNiceSubstringKt")

package com.leetcode

fun canChoose(groups: Array<IntArray>, nums: IntArray): Boolean {

    val strs = groups.map { it.joinToString("_") }
    val total = nums.joinToString("_")

    fun dfs(x: Int, s: String): Boolean {
        if (x >= groups.size) return true

        val index = s.indexOf(strs[x])
        if (index == -1) return false
        return dfs(x + 1, s.substring(index + strs[x].length))
    }

    return dfs(0, total)
}

