package com.leetcode


/**
 * https://leetcode.com/problems/last-substring-in-lexicographical-order/discuss/361121/Python-O(n)-with-explanation
 */
fun lastSubstring(s: String): String {

    val maxChar = s.max()!!
    var indexList = s.withIndex().filter { it.value == maxChar }.map { it.index }

    var now = 1
    while (indexList.size > 1) {
        val char = indexList.map { if (it + now < s.length) s[it+now] else '_' }.max()!!
        indexList = indexList.filter { it + now < s.length && s[it + now] == char }
        now ++

        indexList = indexList.withIndex().filterNot { it.index > 0 && it.value - indexList[it.index - 1] <= now }.map { it.value }
    }

    return s.substring(indexList[0])
}


fun main() {

    println(lastSubstring("abab"))
    println(lastSubstring("leetcode"))
    println(lastSubstring("zzzzzzzzzzz"))
}