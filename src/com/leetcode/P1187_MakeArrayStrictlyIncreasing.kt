package com.leetcode


fun makeArrayIncreasing(arr1: IntArray, arr2: IntArray): Int {
    val m = arr1.size
    val nowArry = arr2.distinct().toIntArray()
    nowArry.sort()

    var n = nowArry.size

    val dp = Array(m) {IntArray(n + 1) {Int.MAX_VALUE} }
    for (j in 0..n) dp[0][j] = 1
    dp[0][n] = 0

    for (i in 1 until m) {
        val minArr = IntArray(n) {Int.MAX_VALUE}
        for (j in 0 until n) {
            minArr[j] = Math.min(dp[i - 1][j], if (j - 1 >= 0) minArr[j - 1] else Int.MAX_VALUE)
        }

        var pos = -1
        for (j in 0 until n) {
            if (arr1[i] > nowArry[j]) pos = j
            else break
        }

        if (pos != -1)  {
            dp[i][n] = Math.min(dp[i][n], minArr[pos])
        }
        if (arr1[i] > arr1[i - 1]) dp[i][n] = Math.min(dp[i][n], dp[i - 1][n])


        for (j in 1 until n) {
            dp[i][j] = Math.min(dp[i][j], if (minArr[j - 1] == Int.MAX_VALUE) Int.MAX_VALUE else minArr[j - 1] + 1)
            if (nowArry[j] > arr1[i - 1]) dp[i][j] = Math.min(dp[i][j], if (dp[i - 1][n] == Int.MAX_VALUE) Int.MAX_VALUE else dp[i - 1][n] + 1)
        }
    }

    val ans = dp[m - 1].min()
    if (ans == Int.MAX_VALUE) return -1
    return ans!!
}


fun main() {

//    println(makeArrayIncreasing(intArrayOf(1, 5, 3, 6, 7), intArrayOf(1, 2, 3, 4)))
//    println(makeArrayIncreasing(intArrayOf(1, 5, 3, 6, 7), intArrayOf(1, 3, 4)))
//    println(makeArrayIncreasing(intArrayOf(1, 5, 3, 6, 7), intArrayOf(1, 6, 3, 3)))
    println(makeArrayIncreasing(intArrayOf(7, 6, 3, 0, 3), intArrayOf(9)))

}