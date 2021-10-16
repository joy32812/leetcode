package com.leetcode

/**
 * Compare the removable numbers
 */
fun winnerOfGame(colors: String): Boolean {

    fun isEqual(i: Int, ch: Char) = i - 1 >= 0 && i + 1 < colors.length && colors[i - 1] == ch && colors[i] == ch && colors[i + 1] == ch

    val numA = colors.indices.map { if (isEqual(it, 'A')) 1 else 0 }.sum()
    val numB = colors.indices.map { if (isEqual(it, 'B')) 1 else 0 }.sum()
    return numA > numB;
}
