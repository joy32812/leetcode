package com.leetcode

/**
 * group by -> toSet.size -> values -> group by -> count
 */
fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
    val gp = logs.groupBy { it[0] }.mapValues { it.value.map { it[1] }.toSet().size }
    val mapValues = gp.values.groupBy { it }.mapValues { it.value.size }

    return (1..k).map { mapValues[it] ?: 0 }.toIntArray()
}

