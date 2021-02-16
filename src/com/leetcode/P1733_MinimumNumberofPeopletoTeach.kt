package com.leetcode

/**
 * brute force
 */
fun minimumTeachings(n: Int, languages: Array<IntArray>, friendships: Array<IntArray>): Int {
    val langSet = languages.map { it.toSet() }
    val nonTalks = friendships.filter { (a, b) -> (langSet[a - 1] intersect langSet[b - 1]).isEmpty() }

    fun learn(x: Int): Int {
        val learnSet = mutableSetOf<Int>()
        nonTalks.forEach { (a, b) ->
            if(x !in langSet[a - 1]) learnSet += a - 1
            if(x !in langSet[b - 1]) learnSet += b - 1
            learnSet.size
        }

        return learnSet.size
    }
    return (1..n).map { learn(it) }.min()!!
}


fun main() {


    println(minimumTeachings(
            17,
            arrayOf(
                    intArrayOf(4,7,2,14,6),
                    intArrayOf(15,13,6,3,2,7,10,8,12,4,9),
                    intArrayOf(16),
                    intArrayOf(10),
                    intArrayOf(10,3),
                    intArrayOf(4,12,8,1,16,5,15,17,13),
                    intArrayOf(4,13,15,8,17,3,6,14,5,10),
                    intArrayOf(11,4,13,8,3,14,5,7,15,6,9,17,2,16,12),
                    intArrayOf(4,14,6),
                    intArrayOf(16,17,9,3,11,14,10,12,1,8,13,4,5,6),
                    intArrayOf(14),
                    intArrayOf(7,14),
                    intArrayOf(17,15,10,3,2,12,16,14,1,7,9,6,4)
            ),
            arrayOf(
                    intArrayOf(4,11),
                    intArrayOf(3,5),
                    intArrayOf(7,10),
                    intArrayOf(10,12),
                    intArrayOf(5,7),
                    intArrayOf(4,5),
                    intArrayOf(3,8),
                    intArrayOf(1,5),
                    intArrayOf(1,6),
                    intArrayOf(7,8),
                    intArrayOf(4,12),
                    intArrayOf(2,4),
                    intArrayOf(8,9),
                    intArrayOf(3,10),
                    intArrayOf(4,7),
                    intArrayOf(5,12),
                    intArrayOf(4,9),
                    intArrayOf(1,4),
                    intArrayOf(2,8),
                    intArrayOf(1,2),
                    intArrayOf(3,4),
                    intArrayOf(5,10),
                    intArrayOf(2,7),
                    intArrayOf(1,7),
                    intArrayOf(1,8),
                    intArrayOf(8,10),
                    intArrayOf(1,9),
                    intArrayOf(1,10),
                    intArrayOf(6,7),
                    intArrayOf(3,7),
                    intArrayOf(8,12),
                    intArrayOf(7,9),
                    intArrayOf(9,11),
                    intArrayOf(2,5),
                    intArrayOf(2,3)
            )
    ))
}
