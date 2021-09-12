package com.leetcode

/**
 * gcd
 */
fun interchangeableRectangles(rectangles: Array<IntArray>): Long {
    fun gcd(a: Int, b: Int): Int = if (a % b == 0) b else gcd(b, a % b)
    val pariMap = mutableMapOf<String, Int>()

    for ((w, h) in rectangles) {
        val g = gcd(w, h)

        val key = "" + (w/g) + "_" + (h/g)
        pariMap[key] = (pariMap[key] ?: 0) + 1
    }

    return pariMap.values.map { 1L * it * (it - 1) / 2 }.sum()
}
