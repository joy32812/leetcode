package com.leetcode

/**
 * brute-force
 */
class Encrypter(keys: CharArray, values: Array<String>, dictionary: Array<String>) {
    val ks = keys
    val vs = values
    val dry = dictionary

    fun encrypt(word1: String): String {
        return word1.map { c -> vs[ks.indexOfFirst { it == c }] }.joinToString("")
    }

    fun decrypt(word2: String): Int {
        return dry.count { encrypt(it) == word2 }
    }

}
