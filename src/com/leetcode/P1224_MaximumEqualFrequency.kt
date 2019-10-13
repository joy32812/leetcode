package com.leetcode

fun maxEqualFreq(nums: IntArray): Int {

    val numMap = mutableMapOf<Int, Int>()
    val xyMap= mutableMapOf<Int, Int>()

    var ans = 0

    for (i in  nums.indices) {
        val d = nums[i]

        if (d in numMap) {
            numMap[d] = (numMap[d] ?: 0) + 1
            val cnt = numMap[d]!!

            xyMap[cnt - 1] = xyMap[cnt - 1]!! - 1
            if (xyMap[cnt - 1] == 0) xyMap -= cnt - 1

            xyMap[cnt] = (xyMap[cnt] ?: 0) + 1
        } else {
            numMap[d] = 1
            xyMap[1] = (xyMap[1] ?: 0) + 1
        }

        if (xyMap.size == 1 && 1 in xyMap.values) {
            ans = Math.max(ans, i + 1)
        }
        if (xyMap.size == 1 && 1 in xyMap) {
            ans = Math.max(ans, i + 1)
        }

        if (xyMap.size == 2 && 1 in xyMap && xyMap[1]!! == 1) {
            ans = Math.max(ans, i + 1)
        }

        if (xyMap.size == 2) {
            val keys = xyMap.keys.sorted()
            if (keys[1] == keys[0] + 1 && xyMap[keys[1]]!! == 1) {
                ans = Math.max(ans, i + 1)
            }
        }
    }

    return ans
}

fun main() {
    println(maxEqualFreq(intArrayOf(1,1)))
    println(maxEqualFreq(intArrayOf(2,2,1,1,5,3,3,5)))
    println(maxEqualFreq(intArrayOf(1,1,1,2,2,2,3,3,3,4,4,4,5)))
    println(maxEqualFreq(intArrayOf(1,1,1,2,2,2)))
    println(maxEqualFreq(intArrayOf(10,2,8,9,3,8,1,5,2,3,7,6)))
}
