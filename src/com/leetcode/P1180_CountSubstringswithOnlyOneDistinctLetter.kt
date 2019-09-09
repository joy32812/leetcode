package com.leetcode

fun countLetters(S: String): Int {

    val numList = S.withIndex().fold(mutableListOf<Int>()) { acc, indexedValue ->
        if (indexedValue.index - 1 >= 0 && indexedValue.value == S[indexedValue.index - 1]) acc[acc.size - 1] = acc.last() + 1
        else acc += 1
        acc
    }

    return numList.sumBy { it * (it + 1) / 2 }
}