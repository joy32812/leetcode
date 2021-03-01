package com.leetcode

fun maxCoins(piles: IntArray): Int {
    piles.sort()

    var i = 0
    var j = piles.size - 2

    var ans = 0
    while (i < j) {
        ans += piles[j]
        i ++
        j -= 2
    }

    return ans
}

