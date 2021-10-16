package com.leetcode

/**
 * Greedy
 * Zip + sum(diff)
 */
fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
    seats.sort()
    students.sort()
    return seats.zip(students).sumBy { Math.abs(it.first - it.second) }
}

fun main() {
    println("Hello")
}
