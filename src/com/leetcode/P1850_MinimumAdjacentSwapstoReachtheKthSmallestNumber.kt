package com.leetcode

/**
 * next permutation
 */
fun getMinSwaps(num: String, k: Int): Int {
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


    val now = num.map { it - '0' }.toIntArray()
    val org = num.map { it - '0' }.toIntArray()

    (1..k).forEach { _ -> nextPermutation(now) }

    var ans = 0
    for (i in now.size -1 downTo 0) {
        var tmp = 0
        for (j in org.size - 1 downTo 0) {
            if (org[j] >= 0) tmp ++
            if (org[j] == now[i]) {
                ans += tmp - 1
                org[j] = -1
                break
            }
        }
    }

    return ans
}
