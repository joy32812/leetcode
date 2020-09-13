package com.leetcode

/**
 * for each c in T
 * check if the first c in S can move to left
 */
fun isTransformable(s: String, t: String): Boolean {
    val pos = s.mapIndexed { index, c -> Pair(c - '0', index) }.groupBy { it.first }.mapValues { it.value.map { it.second } }

    val ind = Array(10) {0}

    for (c in t) {
        val now = c - '0'
        if (!pos.containsKey(now) || ind[now] == pos[now]!!.size) return false

        for (i in 0 until now) {
            if (!pos.containsKey(i) || ind[i] == pos[i]!!.size) continue

            if (pos[i]!![ind[i]] < pos[now]!![ind[now]]) return false
        }

        ind[now]++
    }

    return true
}

fun main() {
    println(isTransformable("84532", "34852"))
    println(isTransformable("1", "2"));
}
