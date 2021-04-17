package com.leetcode

import java.util.*

class MKAverage(m: Int, k: Int) {
    val M = m;
    val K = k;

    class MultiTreeSet() {
        val treeMap = TreeMap<Int, Int>()
        var size = 0
        var sum = 0L

        fun add(x: Int) {
            treeMap[x] = (treeMap[x] ?: 0) + 1
            size ++
            sum += x
        }

        fun del(x: Int) {
            if (x !in treeMap) return
            treeMap[x] = treeMap[x]!! - 1
            if (treeMap[x] == 0) treeMap.remove(x)
            size --
            sum -= x
        }

        fun min() = treeMap.firstKey()
        fun max() = treeMap.lastKey()
        fun has(x: Int) = x in treeMap
        fun isNotEmpty() = treeMap.isNotEmpty()
    }

    fun move(bigger: MultiTreeSet, smaller: MultiTreeSet, needSize: Int) {
        while (smaller.isNotEmpty() && bigger.min() < smaller.max()) {
            val aa = bigger.min()
            val zz = smaller.max()
            bigger.del(aa)
            bigger.add(zz)
            smaller.del(zz)
            smaller.add(aa)
        }

        while (bigger.size > needSize) {
            val aa = bigger.min()
            bigger.del(aa)
            smaller.add(aa)
        }
    }

    val nums = mutableListOf<Int>()
    val small = MultiTreeSet()
    val mid = MultiTreeSet()
    val big = MultiTreeSet()

    fun addElement(num: Int) {
        nums.add(num)

        if (nums.size > M) {
            val rmNum = nums[nums.size - M - 1]
            if (small.has(rmNum)) small.del(rmNum)
            else if (mid.has(rmNum)) mid.del(rmNum)
            else big.del(rmNum)
        }

        big.add(num)
        move(big, mid, K)
        move(mid, small, M - 2 * K)
    }

    fun calculateMKAverage(): Int {
        return if (nums.size < M) -1
        else (1.0 * mid.sum / (M - 2 * K)).toInt()
    }
}

fun main() {
    val obj = MKAverage(3, 1)

    obj.addElement(3)
    obj.addElement(1)
    println(obj.calculateMKAverage())
    obj.addElement(10)
    println(obj.calculateMKAverage())

    obj.addElement(5)
    obj.addElement(5)
    obj.addElement(5)
    println(obj.calculateMKAverage())
}
