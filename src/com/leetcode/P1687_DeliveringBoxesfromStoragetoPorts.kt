package com.leetcode

/**
 * DP + greedy
 */
fun boxDelivering(boxes: Array<IntArray>, portsCount: Int, maxBoxes: Int, maxWeight: Int): Int {
    val dp = Array(boxes.size) { Int.MAX_VALUE / 2 }

    var lastR = 0
    var r = 0
    var totalWeight = 0
    var tripNum = 2

    fun getDpValue(i: Int): Int {
        return if (i < 0 || i >= dp.size) 0 else dp[i]
    }

    for (i in boxes.indices) {
        while (r < boxes.size && r - i + 1 <= maxBoxes && totalWeight + boxes[r][1] <= maxWeight) {
            totalWeight += boxes[r][1]
            if (i == r || boxes[r][0] != boxes[r - 1][0]) lastR = r
            if (i != r && boxes[r][0] != boxes[r - 1][0]) tripNum ++
            r++
        }
        dp[r - 1] = Math.min(dp[r - 1], getDpValue(i - 1) + tripNum)
        if(lastR - 1 >= 0) dp[lastR - 1] = Math.min(dp[lastR - 1], getDpValue(i - 1) + tripNum - 1)

        totalWeight -= boxes[i][1]
        if (i + 1 < r && boxes[i][0] != boxes[i + 1][0]) tripNum --
    }
    return dp[boxes.size - 1]
}

fun main() {
//    [[2,4],[2,5],[3,1],[3,2],[3,7],[3,1],[4,4],[1,3],[5,2]]
//    5
//    5
//    7
    println(boxDelivering(
            arrayOf(
                    intArrayOf(2, 4),
                    intArrayOf(2, 5),
                    intArrayOf(3, 1),
                    intArrayOf(3, 2),
                    intArrayOf(3, 7),
                    intArrayOf(3, 1),
                intArrayOf(4, 4),
                intArrayOf(1, 3),
                intArrayOf(5, 2)
            ),
            5, 5, 7
    ))

}
