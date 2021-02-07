package com.leetcode

fun check(nums: IntArray): Boolean {

    val orgStr = nums.joinToString("_")
    val twoStr = nums.sorted().joinToString("_") + "_" + nums.sorted().joinToString("_")

    return twoStr.contains(orgStr)
}

fun main() {
    println("Hello")
}

