package com.leetcode

/**
 * easy
 */
fun finalValueAfterOperations(operations: Array<String>): Int {
    return operations.map { if (it.contains("+"))  1 else -1 }.sum()
}
