package com.leetcode

/**
 * groupBy
 */
fun areOccurrencesEqual(s: String): Boolean {
    return s.groupBy { it }.values.map { it.size }.toSet().size == 1
}
