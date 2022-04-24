package com.leetcode

/**
 * brute force
 * check in circle.
 */
fun countLatticePoints(circles: Array<IntArray>): Int {

    val max = 200
    fun inCircle(x: Int, y: Int) = circles.any { (a, b, r) -> (x - a) * (x - a) + (y - b) * (y - b) <= r * r }

    return (0..max).flatMap { i -> (0..max).map { i to it } }.count { inCircle(it.first, it.second) }

}
