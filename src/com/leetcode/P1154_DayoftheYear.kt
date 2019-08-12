package com.leetcode


fun dayOfYear(date: String): Int {

    fun leapYear(year: Int): Boolean = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0
    val days = arrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    val split = date.split("-")
    val year = split[0].toInt()
    val month = split[1].toInt()
    val day = split[2].toInt()

    var ans = 0
    for (i in 1 until month) {
        ans += days[i]
        if (i == 2 && leapYear(year)) ans++
    }

    return ans + day

}

fun main() {
    println(dayOfYear("2019-01-09"))
    println(dayOfYear("2019-02-10"))
    println(dayOfYear("2003-03-01"))
    println(dayOfYear("2004-03-01"))
}