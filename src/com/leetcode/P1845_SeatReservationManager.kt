package com.leetcode

import java.util.*

/**
 * TreeSet
 */
class SeatManager(n: Int) {

    val seatSet = TreeSet<Int>()
    init {
        (1..n).forEach { seatSet.add(it) }
    }


    fun reserve(): Int {
        val seat = seatSet.first()
        seatSet.remove(seat)
        return seat
    }

    fun unreserve(seatNumber: Int) {
        seatSet.add(seatNumber)
    }

}
