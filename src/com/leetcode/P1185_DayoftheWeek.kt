package com.leetcode

import java.time.LocalDate
fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
    val localDate = LocalDate.of(year, month, day)
    val result = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    return result[localDate.dayOfWeek.value % 7]
}

fun main() {

    println(dayOfTheWeek(15, 8, 1993))
}