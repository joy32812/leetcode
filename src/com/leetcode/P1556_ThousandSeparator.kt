package com.leetcode

fun thousandSeparator(n: Int): String {
    val strN = "$n"
    if (n < 1000) return strN

    return ("" + n).reversed().mapIndexed { index, c -> if (index % 3 == 2 && index != strN.length - 1) "$c." else "$c" }.joinToString("").reversed()
}
