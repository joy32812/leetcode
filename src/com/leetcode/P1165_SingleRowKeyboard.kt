package com.leetcode

import kotlin.math.abs

fun calculateTime(keyboard: String, word: String): Int {
    val posMap = keyboard.withIndex().associate { it.value to it.index }
    val now = keyboard.substring(0, 1) + word
    return now.zipWithNext().sumBy { abs(posMap[it.second]!! - posMap[it.first]!!) }
}