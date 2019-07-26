package com.leetcode


fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {


    var ans = 0;
    dominoes.groupBy { it.sort(); it[0] * 10 + it[1] }.values.forEach {ans += it.size * (it.size - 1) / 2}
    return ans

}

fun main() {
    println(numEquivDominoPairs(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(3, 4),
            intArrayOf(5, 6)
    )))
}