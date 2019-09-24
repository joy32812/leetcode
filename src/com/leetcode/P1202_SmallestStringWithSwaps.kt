package com.leetcode


fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {

    val fatherMap = mutableMapOf<Int, Int>()
    fun getFather(s: Int): Int = if (s !in fatherMap) s else {fatherMap[s] = getFather(fatherMap[s]!!); fatherMap[s]!!}

    for (p in pairs) {
        val (a, b) = p
        val fa = getFather(a)
        val fb = getFather(b)

        if(fa != fb) fatherMap[fa] = fb
    }


    val group = mutableMapOf<Int, HashSet<Int>>()
    for (i in s.indices) {
        val fa = getFather(i)
        group.computeIfAbsent(fa) {HashSet<Int>()}.add(i)
    }

    val ansMap = mutableMapOf<Int, Char>()
    group.values.forEach { indexSet ->

        val cur = indexSet.map { s[it] }.sorted()
        cur.zip(indexSet.toList().sorted()).forEach {
            ansMap[it.second] = it.first
        }
    }

    return s.indices.map { ansMap[it] }.toList().joinToString("")
}

fun main() {

    println(smallestStringWithSwaps("pwqlmqm", listOf(
            listOf(5, 3),
            listOf(3, 0),
            listOf(5, 1),
            listOf(1, 1),
            listOf(1, 5),
            listOf(3, 0),
            listOf(0, 2)
    )))
}
