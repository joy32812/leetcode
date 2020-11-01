package com.leetcode

fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
    pieces.sortBy { p -> arr.indexOfFirst { it == p[0] } }
    return arr.toList().equals(pieces.flatMap { it.toList() })
}


fun main() {

    println(canFormArray(
            intArrayOf(91, 4, 64, 78),
            arrayOf(
                    intArrayOf(78),
                    intArrayOf(4, 64),
                    intArrayOf(91)
            )
    ));

}
