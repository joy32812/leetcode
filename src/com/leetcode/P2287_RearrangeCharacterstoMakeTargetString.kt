package com.leetcode

/**
 * groupby
 */
fun rearrangeCharacters(s: String, t: String): Int {
    val gs = s.groupBy { it }
    val gt = t.groupBy { it }

    return gt.map { (k, v) -> (gs[k]?.size ?: 0) / v.size }.min()!!
}

