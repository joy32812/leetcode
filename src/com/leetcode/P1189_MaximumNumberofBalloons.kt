package com.leetcode

fun maxNumberOfBalloons(text: String): Int {
    return "balon".map { ch -> if (ch in "ol") text.count { it == ch} / 2 else text.count { it == ch } }.min()!!
}


fun main() {

    println(maxNumberOfBalloons("nlaebolko"))

}
