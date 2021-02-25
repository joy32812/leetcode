package com.leetcode


fun averageWaitingTime(customers: Array<IntArray>): Double {

    var total = 0.0
    var currentTime = 0
    for (cus in customers) {
        if (currentTime > cus[0]) total += currentTime - cus[0]
        total += cus[1]
        currentTime = Math.max(currentTime, cus[0]) + cus[1]
    }

    return total / customers.size
}
