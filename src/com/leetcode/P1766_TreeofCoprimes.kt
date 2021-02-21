package com.leetcode

import java.util.*

fun getCoprimes(nums: IntArray, edges: Array<IntArray>): IntArray {

    val primeMap = mutableMapOf<Int, MutableSet<Int>>()
    val n = 50
    for (i in 1..n) {
        for (j in 1..n) {
            if (i.toBigInteger().gcd(j.toBigInteger()).toInt() == 1) {
                primeMap.getOrPut(i) { mutableSetOf() }.add(j)
                primeMap.getOrPut(j) { mutableSetOf() }.add(i)
            }
        }
    }

    val edgeMap = mutableMapOf<Int, MutableSet<Int>>()
    for (eg in edges) {
        edgeMap.getOrPut(eg[0]) { mutableSetOf() }.add(eg[1])
        edgeMap.getOrPut(eg[1]) { mutableSetOf() }.add(eg[0])
    }

    val ans = Array(nums.size) { -1 }
    // node level
    val indexMap = mutableMapOf<Int, LinkedList<Pair<Int, Int>>>()
    fun dfs(now: Int, parent: Int, lev: Int) {
        var result = -1
        var level = -1
        for (prime in primeMap[nums[now]]!!) {
            if (prime in indexMap && indexMap[prime]!!.size > 0 && indexMap[prime]!!.last().second > level) {
                level = indexMap[prime]!!.last().second
                result = indexMap[prime]!!.last().first
            }
        }
        ans[now] = result

        indexMap.getOrPut(nums[now]) { LinkedList() }.add(Pair(now, lev))
        for (child in edgeMap[now]!!) {
            if (child == parent) continue
            dfs(child, now, lev + 1)
        }
        indexMap[nums[now]]!!.removeLast()
    }

    dfs(0, -1, 0)

    return ans.toIntArray()
}

fun main() {
   println(getCoprimes(
       intArrayOf(2, 3, 3, 2),
       arrayOf(
           intArrayOf(0, 1),
           intArrayOf(1, 2),
           intArrayOf(1, 3)
       )
   ).toList())

}
