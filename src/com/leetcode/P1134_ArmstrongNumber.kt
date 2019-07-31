package com.leetcode



fun isArmstrong(N: Int): Boolean {


    var k = N.toString().length

    var ans: Long = 0
    N.toString().toCharArray().forEach { ans += Math.pow((it - '0').toDouble(), k.toDouble()).toLong() }

    return ans === N.toLong()
}


fun main() {
    println(isArmstrong(153))
}