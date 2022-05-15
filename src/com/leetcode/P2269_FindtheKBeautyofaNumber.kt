package com.leetcode

/**
 * String.windowed
 */
fun divisorSubstrings(num: Int, k: Int): Int {

    return num.toString().windowed(k).count {  it.toInt() != 0 && num % it.toInt() == 0 }

}
