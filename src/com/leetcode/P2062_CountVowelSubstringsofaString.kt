package com.leetcode

/**
 * brute force
 */
fun countVowelSubstrings(word: String): Int {
    var cnt = 0
    fun okay(l: Int, r: Int) = (l..r).map { word[it] }.toSortedSet().joinToString("") == "aeiou"

    for (i in word.indices) {
        for (j in i + 4 until word.length) {
            if (okay(i, j)) cnt ++
        }
    }

    return cnt
}

