package com.leetcode


fun minimizeError(prices: Array<String>, target: Int): String {

    val floor = prices.map { Math.floor(it.toDouble()) }.sum().toInt()
    val ceil = prices.map { Math.ceil(it.toDouble()) }.sum().toInt()
    if (target < floor || target > ceil) return "-1"


    prices.sortByDescending { Math.abs(it.toDouble() - Math.floor(it.toDouble())) }

    val ceilNum = target - floor
    var cnt = 0;
    var ans = 0

    prices.forEach {
        val now = it.replace(".", "").toInt()
        if (cnt < ceilNum) {
            ans += 1000 - now % 1000
            cnt++
        } else {
            ans += now % 1000
        }
    }

    return "" + ans / 1000 + "." + (ans % 1000).toString().padStart(3, '0')
}

fun main() {
//    println(minimizeError(arrayOf("0.700","2.800","4.900"), 8))
    println(minimizeError(arrayOf("2.000","2.000","2.000","2.000","2.000"), 10))
}