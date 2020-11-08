package com.leetcode

/**
 * binary search by the price
 */
fun maxProfit(inventory: IntArray, orders: Int): Int {
    val MOD = 1_000_000_000 + 7

    inventory.sort()

    fun okay(x: Int): Boolean {
        var total = 0L
        for (d in inventory) {
            if (d < x) continue
            total += d - x + 1
            if (total >= orders) return true
        }
        return false
    }

    var l = 1
    var r = 1_000_000_000 + 1

    while (l < r) {
        val m = (l + r) / 2
        if (!okay(m)) r = m
        else l = m  + 1
    }

    var ans = 0L
    var num = 0
    for (d in inventory) {
        if (d < l) continue
        num += d - l + 1
        ans = (ans + 1L * (d + l) * (d - l + 1) / 2 % MOD) % MOD
    }

    return ((ans + 1L * (orders - num) * (l - 1) % MOD) % MOD).toInt()
}

fun main() {

    val inventory = intArrayOf(701695700,915736894,35093938,364836059,452183894,951826038,861556610,441929847,842650446,858413011,457896886,35119509,776620034,396643588,83585103,681609037)
    val orders = 598226067
    println(maxProfit(inventory, orders))
}
