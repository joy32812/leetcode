package com.leetcode

fun maximumWealth(accounts: Array<IntArray>): Int {
    return accounts.map { it.sum() }.max()!!
}

fun main() {
    println("Hello, World!")
}
