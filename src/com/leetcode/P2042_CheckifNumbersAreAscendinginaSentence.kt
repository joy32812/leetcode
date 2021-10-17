package com.leetcode

/**
 * split -> filter -> zip -> checkAll
 */
fun areNumbersAscending(s: String): Boolean {

    return s.split(" ").filter { it[0].isDigit() }.zipWithNext().all { it.first.toInt() < it.second.toInt() }

}
