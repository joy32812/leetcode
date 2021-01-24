package com.leetcode

fun maximumTime(time: String): String {
    val result = time.toCharArray()

    if (result[0] == '?') {
        result[0] = if (result[1] == '?' || result[1] <= '3') '2' else '1'
    }

    if (result[1] == '?') {
        result[1] = if (result[0] == '2') '3' else '9'
    }

    if (result[3] == '?') result[3] = '5'

    if (result[4] == '?') result[4] = '9'

    return result.joinToString("")
}

fun main() {
    println(maximumTime("2?:?0"))
}

