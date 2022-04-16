package com.leetcode

/**
 * simple math
 */
fun waysToBuyPensPencils(total: Int, cost1: Int, cost2: Int): Long {

    return (0..total / cost1).map { 1L * (total - it * cost1) / cost2 + 1 }.sum()

}
