package com.leetcode

import java.util.*

/**
 * try possible K
 */
fun recoverArray(nums: IntArray): IntArray {
    val n = nums.size / 2
    nums.sort()

    val cntMap = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            val k = nums[j] - nums[i]
            cntMap[k] = 1 + (cntMap[k] ?: 0)
        }
    }

    var ans = mutableListOf<Int>()

    fun okay(k: Int): Boolean {
        ans = mutableListOf<Int>()

        val treeMap = TreeMap<Int, Int>()
        for (d in nums) treeMap[d] = 1 + (treeMap[d] ?: 0)

        fun removeOne(key: Int): Boolean {
            if (key !in treeMap) return false
            treeMap[key] = treeMap[key]!! - 1

            if (treeMap[key]!! == 0) treeMap.remove(key)
            return true
        }

        while (treeMap.isNotEmpty()) {

            val a1 = treeMap.firstKey() + k
            val an = treeMap.lastKey() - k

            if (!removeOne(a1 - k)) return false
            if (!removeOne(a1 + k)) return false
            if (a1 != an && !removeOne(an - k)) return false
            if (a1 != an && !removeOne(an + k)) return false

            ans.add(a1)
            if (a1 != an) ans.add(an)
        }

        return true
    }

    for ((k, v) in cntMap) {

        if (k > 0 && k % 2 == 0 && v >= n) {
            if (okay(k / 2)) break
        }

    }

    return ans.toIntArray()
}

fun main() {

    println(recoverArray(intArrayOf(10, 6, 11, 7)).toList())

}
