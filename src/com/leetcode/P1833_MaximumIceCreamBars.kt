package com.leetcode

fun maxIceCream(costs: IntArray, coins: Int): Int {

    costs.sort()

    var leftCoin = coins
    for (i in costs.indices) {
        if (leftCoin < costs[i]) return i
        leftCoin -= costs[i]
    }

    return costs.size
}
