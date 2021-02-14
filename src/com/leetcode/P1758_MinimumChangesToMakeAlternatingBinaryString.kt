package com.leetcode

import kotlin.math.min

/**
 * easy
 */
fun minOperations(s: String): Int {
    val odd = s.filterIndexed { index, c -> index % 2 == 1 }
    val even = s.filterIndexed { index, c -> index % 2 == 0 }

    return min(
            odd.count { it == '0' } + even.count { it == '1' },
            odd.count { it == '1' } + even.count { it == '0' }
    )
}

