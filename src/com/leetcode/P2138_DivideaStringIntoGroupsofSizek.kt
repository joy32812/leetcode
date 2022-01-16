package com.leetcode

/**
 * String.window
 */
fun divideString(s: String, k: Int, fill: Char): Array<String> {
    return s.windowed(k, k, true).map { if (it.length == k) it else it +  fill.toString().repeat(k - it.length)}.toTypedArray()
}
