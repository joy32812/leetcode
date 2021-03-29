package com.leetcode

import java.math.BigInteger

/**
 * map -> split -> filter -> map -> toSet
 */
fun numDifferentIntegers2(word: String): Int {
    val numStrs = word.map { if (it.isDigit()) it else '_' }.joinToString("").split("_").filter { it.isNotEmpty() }
    return numStrs.map { it.toBigInteger() }.toSet().size
}

fun numDifferentIntegers(word: String): Int {

    var numStr = ""
    var i = 0
    val set = mutableSetOf<BigInteger>()
    while (i < word.length) {
        if (word[i].isDigit()) {
            numStr += word[i]
        } else {
            if (numStr.length > 0) {
                set.add(numStr.toBigInteger())
                numStr = ""
            } else {
                numStr = ""
            }
        }
        i++
    }
    if (numStr.length > 0) {
        set.add(numStr.toBigInteger())
    }

    return set.size
}


fun main() {

}
