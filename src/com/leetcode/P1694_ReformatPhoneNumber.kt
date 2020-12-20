package com.leetcode


/**
 * easy
 */
fun reformatNumber(number: String): String {
    var phone = number.filter { it != ' ' && it != '-' }

    var ans = ""
    while (phone.length > 4) {
        ans += phone.substring(0..2) + "-"
        phone = phone.substring(3)
    }

    if (phone.length <= 3) return ans + phone
    return ans + phone.substring(0..1) + "-" + phone.substring(2)
}

fun main() {
    println("Hello");
}
