package com.leetcode

/**
 * Map + brute force
 */
fun matchReplacement(s: String, sub: String, mappings: Array<CharArray>): Boolean {

    val gbMap = mappings.groupBy { it[0] }.mapValues { ca -> ca.value.map { it[1] }.toSet() }
    fun match(p: Int) = sub.indices.all { sub[it] == s[p + it] || s[p + it] in (gbMap[sub[it]] ?: emptySet()) }

    return (0 .. s.length - sub.length).any { match(it) }
}
