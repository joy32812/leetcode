package com.leetcode

fun numberOfDays(Y: Int, M: Int): Int {

    val leap = (Y % 4 == 0 && Y % 100 != 0) || Y % 400 == 0
    if (leap && M == 2) return 29


    if (M in arrayListOf(1, 3, 5, 7, 8, 10, 12)) return 31
    if (M == 2) return 28

    return 30

}