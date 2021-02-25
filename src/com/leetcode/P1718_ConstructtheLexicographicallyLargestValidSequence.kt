package com.leetcode

/**
 * greedy + back tracking
 */
fun constructDistancedSequence(n: Int): IntArray {

    var ans = intArrayOf()


    fun dfs(nums: Array<Int>, result: Array<Int>) {
        if (result.all { it != 0 }) {
            ans = result.toIntArray()
            return
        }

        val ofFirst = result.indexOfFirst { it == 0 }

        for (i in n downTo 1) {
            if (nums[i] != 1) continue

            nums[i] = 0
            result[ofFirst] = i

            if (i == 1) {
                dfs(nums, result)
            } else if (ofFirst + i < result.size && result[ofFirst + i] == 0) {
                result[ofFirst + i] = i
                dfs(nums, result)
                result[ofFirst + i] = 0
            }

            if (ans.isNotEmpty()) return

            result[ofFirst] = 0
            nums[i] = 1
        }
    }

    val nums = Array(n + 1) {1}
    dfs(nums, Array(2 * n - 1) {0})

    return ans
}


fun main() {

    println(constructDistancedSequence(3).toList())
    println(constructDistancedSequence(4).toList())
    println(constructDistancedSequence(5).toList())

}
