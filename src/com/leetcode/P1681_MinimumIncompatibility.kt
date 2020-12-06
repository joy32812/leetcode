package com.leetcode

fun minimumIncompatibility(nums: IntArray, k: Int): Int {

    val n = nums.size
    val numInOneGroup = n / k

    val gb = nums.groupBy { it }.mapValues { it.value.size }.toList().sortedBy { it.first }.toMutableList()
    val indexMap = gb.withIndex().map { it.value.first to it.index }.toMap()

    val tmpArray = Array(n) {0}

    fun possible(gpNum: Int): Boolean {
        return gb.map { it.second }.max()!! <= gpNum
    }

    var ans = Int.MAX_VALUE
    fun dfs(p: Int) {
        if (p == n) {
            var sum = 0
            for (i in 0 until k) {
                val l = i * numInOneGroup
                val r = (i + 1) * numInOneGroup - 1
                sum += tmpArray[r] - tmpArray[l]
            }
            ans = Math.min(ans, sum)

            return
        }

        if (p % numInOneGroup == 0) {
            if (!possible((n - p) / numInOneGroup)) return
            for ((first, second) in gb) {
                if (second > 0) {
                    val i = indexMap[first]!!
                    tmpArray[p] = first
                    gb[i] = Pair(first, second - 1)
                    dfs(p + 1)
                    gb[i] = Pair(first, second)
                    break
                }
            }
            return
        }


        val i = indexMap[tmpArray[p - 1]]!!
        for (j in i + 1 until gb.size) {
            val (first, second) = gb[j]
            if (second > 0) {
                tmpArray[p] = first
                gb[j] = Pair(first, second - 1)
                dfs(p + 1)
                gb[j] = Pair(first, second)
            }
        }
    }

    dfs(0)

    return if (ans == Int.MAX_VALUE) -1 else ans
}

fun main() {
//    println(minimumIncompatibility(intArrayOf(1, 2, 1, 4), 2))
    println(minimumIncompatibility(intArrayOf(6,3,8,1,3,1,2,2), 4))
//    println(minimumIncompatibility(intArrayOf(5,3,3,6,3,3), 3))
}
