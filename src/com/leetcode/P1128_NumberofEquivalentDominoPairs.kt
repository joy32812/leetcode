package com.leetcode


fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {

    val map = mutableMapOf<String, Int>()
    for (ia in dominoes) {
        ia.sort()
        val key = "" + ia[0] + "_" + ia[1];
        map.put(key, map.getOrDefault(key, 0) + 1)
    }


    var ans = 0;
    map.values.forEach {ans += it * (it - 1) / 2}
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