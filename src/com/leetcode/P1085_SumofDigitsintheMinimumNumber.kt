package com.leetcode


fun sumOfDigits(A: IntArray): Int {

    return if (A.min().toString().map { it - '0' }.sum() % 2 == 1) 0 else 1

}