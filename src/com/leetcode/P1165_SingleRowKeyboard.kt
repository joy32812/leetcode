package com.leetcode

import kotlin.math.abs

fun calculateTime(keyboard: String, word: String): Int {
    val posMap = keyboard.withIndex().associate { it.value to it.index }
    return ("" + keyboard[0] + word).zipWithNext().sumBy { abs(posMap[it.second]!! - posMap[it.first]!!) }
}