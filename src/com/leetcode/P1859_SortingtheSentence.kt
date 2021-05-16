package com.leetcode

fun sortSentence(s: String): String {
    fun getStr(x: String) = x.filter { it.isLetter() }
    fun getIndex(x: String) = x.filter { it.isDigit() }.toInt()
    return s.split(" ").map { getIndex(it) to getStr(it) }.sortedBy { it.first }.map { it.second }.joinToString(" ")
}
