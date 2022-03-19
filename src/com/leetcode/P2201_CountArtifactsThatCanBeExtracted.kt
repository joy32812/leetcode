package com.leetcode

/**
 * flatMap
 */
fun digArtifacts(n: Int, artifacts: Array<IntArray>, dig: Array<IntArray>): Int {

    val digSet = dig.map { it[0] * 1000 + it[1] }.toSet()

    return artifacts.count {
        val (r1, c1, r2, c2) = it
        (r1..r2).flatMap { r -> (c1..c2).map { c -> r * 1000 + c } }.all { it in digSet }
    }

}
