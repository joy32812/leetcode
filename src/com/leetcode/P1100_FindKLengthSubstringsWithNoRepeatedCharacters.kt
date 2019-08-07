package com.leetcode


fun numKLenSubstrNoRepeats(S: String, K: Int): Int {
    if (S.length < K) return 0

    val map = mutableMapOf<Char, Int>()
    S.substring(0, K).groupBy { it }.forEach { map[it.key] = it.value.size }

    var ans = 0
    if (map.size == K) ans ++

    for (i in K until S.length) {
        val lastCh = S[i - K]
        map[lastCh] = map[lastCh]!! - 1
        if (map[lastCh] == 0) map.remove(lastCh)

        map.put(S[i], map.getOrDefault(S[i], 0) + 1)

        if (map.size == K) ans++
    }

    return ans
}

fun main() {
    println(numKLenSubstrNoRepeats("havefunonleetcode", 5))
    println(numKLenSubstrNoRepeats("home", 5))
}