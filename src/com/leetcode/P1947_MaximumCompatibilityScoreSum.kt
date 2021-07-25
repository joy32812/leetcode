package com.leetcode

/**
 * next permutation
 */
fun maxCompatibilitySum(students: Array<IntArray>, mentors: Array<IntArray>): Int {

    fun swap(nums: IntArray, i: Int, index: Int) {
        val temp = nums[index]
        nums[index] = nums[i]
        nums[i] = temp
    }
    fun reverse(nums: IntArray, i: Int, j: Int) {
        var i = i
        var j = j
        while (i < j) {
            swap(nums, i, j)
            i++
            j--
        }
    }
    fun nextPermutation(nums: IntArray) {
        val n = nums.size
        var index = -1
        for (i in n - 1 downTo 1) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1
                break
            }
        }
        if (index == -1) {
            reverse(nums, 0, n - 1)
            return
        }
        var j = n - 1
        for (i in n - 1 downTo index + 1) {
            if (nums[i] > nums[index]) {
                j = i
                break
            }
        }
        swap(nums, index, j)
        reverse(nums, index + 1, n - 1)
    }

    val m = mentors.size
    val n = mentors[0].size
    val mentorOrder = mentors.indices.toList().toIntArray()

    val pair = Array(m) { Array(m) { 0 } }
    for (i in students.indices) {
        for (j in mentors.indices) {
            pair[i][j] = (0 until n).map { if (students[i][it] == mentors[j][it]) 1 else 0 }.sum()
        }
    }




    val total = (1..m).reduce { acc, i -> acc * i }
    var ans = 0

    (1..total).forEach {
        var tmp = 0
        for (i in students.indices) {
            val j = mentorOrder[i]
            tmp += pair[i][j]
        }

        ans = Math.max(ans, tmp)

        nextPermutation(mentorOrder)
    }

    return ans
}
