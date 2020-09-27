package com.leetcode

/**
 * easy. use stack or list
 */
fun minOperations(logs: Array<String>): Int {

    val folders = mutableListOf<String>()
    for (log in logs) {
        if (log == "../") {
            if (folders.size > 0) folders.removeAt(folders.size - 1)
        } else if (log == "./") {
        } else {
            folders += log
        }
    }

    return folders.size
}


fun main() {
    println(minOperations(listOf("d1/","d2/","../","d21/","./").toTypedArray()))
}
