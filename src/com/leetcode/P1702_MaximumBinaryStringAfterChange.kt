package com.leetcode

fun maximumBinaryString(binary: String): String {
    val index = binary.indexOfFirst { it == '0' }
    if (index == -1) return binary

    val nowBinary = binary.substring(index)

    val zeroNum = nowBinary.count { it == '0' }
    val oneNum = nowBinary.count { it == '1' }
    return "1".repeat(index + zeroNum - 1) + "0" + "1".repeat(oneNum)
}


fun main() {
    println(maximumBinaryString("1100"))
}

