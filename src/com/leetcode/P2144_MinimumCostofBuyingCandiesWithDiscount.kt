package com.leetcode


/**
 * Greedy
 */
fun minimumCost(cost: IntArray): Int {

    return cost.sortedDescending().withIndex().sumBy { if (it.index % 3 == 2) 0 else it.value }

}


