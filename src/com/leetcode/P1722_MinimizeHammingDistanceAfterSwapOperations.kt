package com.leetcode

/**
 * union-find
 */
fun minimumHammingDistance(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int {
    val father = source.indices.toMutableList()

    fun getFather(x: Int): Int {
        if (father[x] == x) return x
        father[x] = getFather(father[x])
        return father[x]
    }

    for (swap in allowedSwaps) {
        val fa = getFather(swap[0])
        val fb = getFather(swap[1])
        father[fa] = fb
    }


    val gb = father.map { getFather(it) }.mapIndexed { index, i -> Pair(index, i) }.groupBy { it.second }.mapValues {
        entry -> entry.value.map { it -> it.first }
    }

    return gb.values.sumBy { indexes ->

            val sourceList = indexes.map { source[it] }
            val targetList = indexes.map { target[it] }
            val sourceGb = sourceList.groupBy { it }
            val targetGb = targetList.groupBy { it }
            sourceList.size - sourceList.intersect(targetList).sumBy { Math.min(sourceGb[it]!!.size, targetGb[it]!!.size) }

    }

}

fun main() {

    println(minimumHammingDistance(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(2, 1, 4, 5),
            arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(2, 3)
            )
    ))

}
