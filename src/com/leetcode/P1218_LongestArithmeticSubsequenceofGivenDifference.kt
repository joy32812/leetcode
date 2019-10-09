package com.leetcode


fun longestSubsequence(arr: IntArray, difference: Int): Int {

    val diff = difference
    val data = arr.toList()

    val map = mutableMapOf<Int, Int>()

    for (d in data) {
        if (d - diff in map) {
            map[d] = map[d - diff]!! + 1
        } else {
            map[d] = 1
        }
    }

    return map.values.max()!!
}


fun main() {

    println("Hello, World! 2222")

}
