package com.leetcode

/**
 * Bruteforce
 */
fun smallestTrimmedNumbers(nums: Array<String>, queries: Array<IntArray>): IntArray {

    return queries.map { (k, t) ->

        nums.mapIndexed { i, s -> s.substring(s.length - t).toBigInteger() to i }.sortedBy { it.first }[k - 1].second

    }.toIntArray()

}
