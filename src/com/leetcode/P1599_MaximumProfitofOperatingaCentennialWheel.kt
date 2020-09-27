package com.leetcode

/**
 * greedy
 */
fun minOperationsMaxProfit(customers: IntArray, boardingCost: Int, runningCost: Int): Int {

    var maxProfit = -1
    var ans = -1

    var nowNum = 0
    var nowProfit = 0

    var times = 0

    fun run() {
        times ++

        val currentNum = Math.min(4, nowNum);
        nowProfit += currentNum * boardingCost - runningCost

        if (maxProfit < nowProfit) {
            maxProfit = nowProfit
            ans = times
        }

        nowNum -= currentNum
    }

    for (num in customers) {
        nowNum += num
        run()
    }

    while (nowNum > 0) {
        run()
    }

    return ans
}
