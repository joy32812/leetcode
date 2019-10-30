package com.leetcode

fun circularPermutation(n: Int, start: Int): List<Int> {

    var now = listOf(0)

    for (i in 1..n) {

        var tmp = mutableListOf<Int>()
        tmp.addAll(now)

        for (j in now.indices.reversed()) {
            tmp.add((1 shl (i - 1)) + now[j])
        }
        now = tmp
    }

    val beg = now.withIndex().first { it.value == start }.index

    val ans = mutableListOf<Int>()
    ans.addAll(now.subList(beg, now.size))
    ans.addAll(now.subList(0, beg))

    return ans

}

fun main() {

    println("Hello12!")
    println(circularPermutation(2, 3))
    println(circularPermutation(3, 2))

}
