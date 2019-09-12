package com.leetcode


fun beforeAndAfterPuzzles(phrases: Array<String>): List<String> {

    val ansSet = sortedSetOf<String>()

    for (i in phrases.indices) {
        for (j in phrases.indices) {
            if (i == j) continue

            if (phrases[i].split(" ").last() == phrases[j].split(" ").first()) {
                val word = phrases[i].split(" ").last()
                ansSet += phrases[i] + phrases[j].substring(word.length)
            }
        }
    }
    return ansSet.toList()
}
