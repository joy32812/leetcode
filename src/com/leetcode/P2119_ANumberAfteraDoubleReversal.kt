package com.leetcode

/**
 * easy
 * extension function
 */
fun isSameAfterReversals(num: Int): Boolean {
    fun Int.reversedInt() = toString().reversed().toInt()
    return num.reversedInt().reversedInt() == num
}
