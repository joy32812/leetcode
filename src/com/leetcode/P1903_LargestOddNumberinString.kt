package com.leetcode

/**
 * easy. find right most index with odd digit
 */
fun largestOddNumber(num: String): String {
    val ofLast = num.indexOfLast { (it - '0') % 2 == 1 }
    return if (ofLast == -1) "" else num.substring(0..ofLast)
}
