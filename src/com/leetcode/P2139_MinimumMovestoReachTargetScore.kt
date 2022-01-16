package com.leetcode

/**
 * Greedy
 */
fun minMoves(target: Int, maxDoubles: Int): Int {

    var ans = 0
    var now = target
    var doubleNumber = maxDoubles
    while (now != 1 && doubleNumber > 0) {
        if (now % 2 == 0) {
            ans ++
            doubleNumber --
            now /= 2
        } else {
            ans ++
            now --
        }
    }

    return ans + now - 1
}
