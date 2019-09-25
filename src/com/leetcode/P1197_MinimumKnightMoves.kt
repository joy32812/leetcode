package com.leetcode

import java.util.*


fun minKnightMoves(nx: Int, ny: Int): Int {

    val zx = Math.abs(nx)
    val zy = Math.abs(ny)

    val dx = intArrayOf(1, 1, -1, -1, 2, 2, -2, -2)
    val dy = intArrayOf(2, -2, 2, -2, 1, -1, 1, -1)


    val disMap = mutableMapOf<Pair<Int, Int>, Int>()
    disMap[Pair(0, 0)] = 0


    val Q = LinkedList<Pair<Int, Int>>()
    Q.add(Pair(0, 0))

    while (!Q.isEmpty()) {
        val (x, y) = Q.poll()
        val dis = disMap[Pair(x, y)]!!

        for (k in dx.indices) {
            val tx = x + dx[k]
            val ty = y + dy[k]

            if (Math.abs(tx) + Math.abs(ty) > 300) continue
            if (Pair(tx, ty) !in disMap && tx > -10 && ty > -10) {

                if (tx == zx && ty == zy) return dis + 1
                disMap[Pair(tx, ty)] = dis + 1
                Q.add(Pair(tx, ty))
            }
        }
    }

    return disMap[Pair(zx, zy)]!!
}

fun main() {
    println(minKnightMoves(-35, 211))
}
