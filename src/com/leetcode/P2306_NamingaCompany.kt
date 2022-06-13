package com.leetcode

/**
 * group by the first letter.
 */
fun distinctNames(ideas: Array<String>): Long {

    var ans = 0L
    val gb = ideas.groupBy { it[0] }.mapValues { it.value.map { it.substring(1) }.toSet() }

    for (x in 'a'..'z') {

        for (y in (x + 1)..'z') {

            val setX = gb[x] ?: emptySet()
            val setY = gb[y] ?: emptySet()

            val c1 = setX.count { it !in setY }
            val c2 = setY.count { it !in setX }

           ans += 1L * c1 * c2
        }
    }


    return ans * 2
}
