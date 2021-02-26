package com.leetcode

import java.util.*

fun minimumJumps(forbidden: IntArray, a: Int, b: Int, x: Int): Int {
    val forbiddenSet = forbidden.toSet()

    val dis = mutableMapOf<Int, Int>()
    val Q = LinkedList<Int>()
    Q.push(0)
    dis[0] = 0


    fun addToQ(next: Int, value: Int) {
        if (next < 10000 && next !in dis && Math.abs(next) !in forbiddenSet) {
            Q.push(next)
            dis[next] = value
        }
    }

    while (Q.isNotEmpty()) {
        val pos = Q.pollLast()

        if (pos < 0) {
            addToQ(a - pos, dis[pos]!! + 1)
        } else {
            addToQ(a + pos, dis[pos]!! + 1)
            if(pos > b) addToQ(-(pos - b), dis[pos]!! + 1)
        }
    }

    if (x in dis && -x in dis) return Math.min(dis[x]!!, dis[-x]!!)
    if (x in dis) return dis[x]!!
    if (-x in dis) return dis[-x]!!
    return -1
}

fun main() {

   println(minimumJumps(
       intArrayOf(1998),
       1999,
       2000,
       2000
   ))

}
