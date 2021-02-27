package com.leetcode


/**
 * brute force
 */
fun findLexSmallestString(s: String, a: Int, b: Int): String {

    val strSet = mutableSetOf<String>()
    fun addAtoStr(now: String) = now.toCharArray().mapIndexed { index, c -> if (index % 2 == 0) c else '0' + (c - '0' + a) % 10 }.joinToString("")

    fun dfs(now: String) {
        if (now in strSet) return
        strSet += now
        dfs(addAtoStr(now))
        dfs(now.substring(b) + now.substring(0, b))
    }

    dfs(s)
    return strSet.min()!!
}

fun main() {
    val chars = charArrayOf('a', 'b')
    val z = chars.toString()
    println(z)
}
