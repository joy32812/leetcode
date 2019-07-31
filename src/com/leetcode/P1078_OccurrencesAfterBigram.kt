package com.leetcode


fun findOcurrences(text: String, first: String, second: String): Array<String> {

    val split = text.split(" ")

    val ans = arrayListOf<String>()
    for (i in 2 until split.size) {
        if (split[i - 2] == first && split[i - 1] == second) ans.add(split[i])
    }

    return ans.toTypedArray()
}