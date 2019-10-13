package com.leetcode


/**
 * find all prefix sum == 0
 */
fun balancedStringSplit2(s: String): Int {

    var ans = 0
    var total = 0
    for (i in s.indices) {
        if (s[i] == 'L') total ++
        else total --

        if (total == 0) ans++
    }

    return ans
}


fun balancedStringSplit(s: String): Int {

    val sumList = s.fold(mutableListOf<Int>()) { acc, c ->
        var last = if (acc.isEmpty()) 0 else acc.last()
        last += if (c == 'L') -1 else 1
        acc += last

        acc
    }

    return sumList.count { it == 0 }
}

fun main() {
    println("h")
}
