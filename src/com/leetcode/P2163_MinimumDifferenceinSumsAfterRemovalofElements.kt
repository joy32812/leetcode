package com.leetcode

import java.util.*

/**
 * Keep 3 TreeMap
 * iterate the array from [n, 2*n)
 * left: smaller n numbers
 * right: biggest n numbers
 */
fun minimumDifference2(nums: IntArray): Long {
    val n = nums.size / 3

    class MyBucket {
        private val treeMap = TreeMap<Int, Int>()
        var sum = 0L
        var size = 0

        fun add(key: Int) {
            treeMap[key] = (treeMap[key] ?: 0) + 1
            size ++
            sum += key
        }

        fun del(key: Int) {
            if (key !in treeMap) return
            treeMap[key] = treeMap[key]!! - 1
            size --
            sum -= key

            if (treeMap[key] == 0) treeMap.remove(key)
        }

        fun max() = treeMap.lastKey()
        fun min() = treeMap.firstKey()
        fun has(key: Int) = key in treeMap
    }

    val left = MyBucket()
    val mid = MyBucket()
    val right = MyBucket()

    (0 until n).forEach { left.add(nums[it]) }

    for (i in n until 3 * n) {
        val d = nums[i]

        if (right.size < n) right.add(d)
        else if (d > right.min()) {
            val min = right.min()
            right.del(min)
            right.add(d)

            mid.add(min)
        } else mid.add(d)
    }

    var ans = left.sum - right.sum

    for (i in n until 2 * n) {
        val d = nums[i]

        if (d < left.max()) {
            left.add(d)
            left.del(left.max())
        }
        if (mid.has(d)) mid.del(d)
        else {
            right.del(d)
            right.add(mid.max())
            mid.del(mid.max())
        }

        ans = Math.min(ans, left.sum - right.sum)
    }

    return ans
}
