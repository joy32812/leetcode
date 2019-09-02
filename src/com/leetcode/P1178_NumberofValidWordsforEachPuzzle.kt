package com.leetcode



fun findNumOfValidWords(words: Array<String>, puzzles: Array<String>): List<Int> {

    val numMap = mutableMapOf<Int, Int>()
    words.forEach {
        var mask = 0
        it.toSet().forEach { mask = mask or (1 shl (it - 'a')) }
        numMap[mask] = (numMap[mask] ?: 0) + 1
    }


    val ans = mutableListOf<Int>()
    puzzles.forEach {p ->

        var cnt = 0
        var mask = 0
        p.forEach { ch -> mask = mask or (1 shl (ch - 'a')) }

        var now = mask
        while (now > 0) {
            if (now and (1 shl (p[0] - 'a')) > 0) cnt += numMap[now] ?: 0
            now = (now - 1) and mask
        }
        ans += cnt
    }

    return ans
}

fun main() {
    println(findNumOfValidWords(arrayOf("aaaa","asas","able","ability","actt","actor","access"), arrayOf("aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz")))

    setOf(1, 2, 3)

    var mask = 6
    var j = mask
    while (j > 0) {
        println(j)
        j = (j - 1) and mask
    }

}
