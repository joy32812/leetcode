package com.leetcode

/**
 * need boundary check
 */
fun minCostSetTime(startAt: Int, moveCost: Int, pushCost: Int, targetSeconds: Int): Int {

    fun getCost(x: Int, y: Int): Int {
        if (x > 99 || y > 99) return Int.MAX_VALUE

        val res = "" + (x / 10) + (x % 10) + (y / 10) + (y % 10)

        var begin = true
        var now = startAt

        var ans = 0

        for (ch in res) {
            if (begin && ch == '0') continue
            begin = false

            if (now != (ch - '0')) ans += moveCost
            ans += pushCost

            now = ch - '0'
        }

        return ans
    }

    val a = targetSeconds / 60
    val b = targetSeconds % 60
    var cost = getCost(a, b)
    if (b + 60 <= 99) cost = Math.min(cost , getCost(a - 1, b + 60))
    return cost
}
