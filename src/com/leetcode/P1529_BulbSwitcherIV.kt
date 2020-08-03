package com.leetcode

fun minFlips(target: String): Int {
    var flipTimes = 0
    for (t in target) {
        if ((t == '1' && flipTimes % 2 == 0) || t == '0' && flipTimes % 2 == 1) {
            flipTimes ++
        }
    }

    return flipTimes
}
