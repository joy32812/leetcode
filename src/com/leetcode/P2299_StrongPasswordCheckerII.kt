package com.leetcode


/**
 * Easy
 * Kotlin functional programming
 */
fun strongPasswordCheckerII(password: String): Boolean {

    if (password.length < 8) return false
    if (password.none { it in 'a'..'z' }) return false
    if (password.none { it in 'A'..'Z' }) return false
    if (password.none { it in '0'..'9' }) return false
    if (password.none { it in "!@#$%^&*()-+" }) return false
    if (password.zipWithNext().any { it.first == it.second }) return false

    return true

}

fun main() {
    println("Hello, World!")
}
