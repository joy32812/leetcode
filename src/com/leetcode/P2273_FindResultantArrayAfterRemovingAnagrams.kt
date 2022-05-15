package com.leetcode

/**
 * isAnagram
 * filterNotNull
 */
fun removeAnagrams(words: Array<String>): List<String> {

    fun String.sorted() = toCharArray().sorted().toString()
    fun isAnagram(x: String, y: String) = x.sorted() == y.sorted()

    return words.mapIndexed { i, s -> if (i - 1 < 0 || !isAnagram(s, words[i - 1])) s else null }.filterNotNull().toList()
}
