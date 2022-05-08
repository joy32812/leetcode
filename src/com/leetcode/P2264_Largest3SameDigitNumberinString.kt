package com.leetcode

/**
 * easy. compare neighboring digits
 */
fun largestGoodInteger(num: String): String {

    return (1 until num.length - 1).map {
        if (num[it] == num[it - 1] && num[it] == num[it + 1]) "${num[it]}".repeat(3) else ""
    }.max()!!

}
