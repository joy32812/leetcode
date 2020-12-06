package com.leetcode

fun interpret(command: String): String {
    return command.replace("()", "o").replace("(al)", "al");
}

fun main() {
    println("Hello")
}
