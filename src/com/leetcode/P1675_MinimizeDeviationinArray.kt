package com.leetcode

/**
 * slide window
 */
fun minimumDeviation(nums: IntArray): Int {
    class Item(val num: Int, val ind: Int);
    val possibles = mutableListOf<Item>()

    // pretreatment
    for (i in nums.indices) {
        var d = nums[i]
        if (d % 2 == 1) {
            possibles += Item(d, i)
            possibles += Item(d * 2, i)
        } else {
            while (d % 2 == 0) {
                possibles += Item(d, i);
                d /= 2
            }
            possibles += Item(d, i)
        }
    }

    // sort
    possibles.sortBy { it.num }

    // slide window
    var left = 0
    var ans = Int.MAX_VALUE
    var needed = nums.size
    var has = Array(needed) {0}
    for (p in possibles) {
        has[p.ind] ++
        if (has[p.ind] == 1) needed --

        if (needed <= 0) {
            ans = Math.min(ans, p.num - possibles[left].num)
            while (has[possibles[left].ind] >= 2) {
                has[possibles[left].ind] --
                left ++
                ans = Math.min(ans, p.num - possibles[left].num)
            }
        }
    }

    return ans
}

fun main() {
    println("Hello, World!")
}
