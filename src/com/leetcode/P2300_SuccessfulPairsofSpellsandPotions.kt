package com.leetcode

/**
 * Slide window
 * Or Binary search
 */
fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {

    val ansMap = mutableMapOf<Int, Int>()
    val sorted = spells.toSet().sorted()

    potions.sort()
    var j = potions.size - 1
    for (i in sorted) {
        while (j >= 0 && 1L * i * potions[j] >= success) {
            j --
        }

        ansMap[i] = potions.size - j - 1
    }

    return spells.map { ansMap[it] ?: 0 }.toIntArray()
}
