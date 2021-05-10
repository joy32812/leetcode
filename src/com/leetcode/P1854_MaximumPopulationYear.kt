package com.leetcode

/**
 * easy
 * brute-force
 */
fun maximumPopulation(logs: Array<IntArray>): Int {

    return (1950..2049).map { year -> year to logs.count { year >= it[0] && year < it[1] } }.maxBy { it.second }!!.first

}
