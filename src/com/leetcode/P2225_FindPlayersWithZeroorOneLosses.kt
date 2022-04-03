package com.leetcode

/**
 * Set minus
 * List groupBy
 */
fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    val winners = matches.map { it[0] }.toSet()
    val losers = matches.map { it[1] }.toSet()

    val realWinners = (winners - losers).toList().sorted()
    val oneLoserGroup = matches.groupBy { it[1] }.filter { it.value.size == 1 }.keys.toList().sorted()

    return listOf(realWinners, oneLoserGroup)
}

