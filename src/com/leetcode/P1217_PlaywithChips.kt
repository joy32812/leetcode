package com.leetcode


fun minCostToMoveChips(chips: IntArray): Int {


    var ans = Int.MAX_VALUE

    fun work(p: Int): Int {

        var ret = 0
        for (d in chips) {
            if (Math.abs(p - d) % 2 == 1) {
                ret ++
            }
        }

        return ret
    }

    for (p in chips) {
        ans = Math.min(ans, work(p))
    }

    return ans
}


fun main() {

    println("Hello, World! 1111")

}
