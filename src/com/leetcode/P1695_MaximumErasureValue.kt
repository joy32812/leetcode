package com.leetcode


/**
 * sliding-window
 */
fun maximumUniqueSubarray(nums: IntArray): Int {

    val cnt = Array(10_000 + 1) {0}

    var ans = 0
    var l = 0
    var sum = 0
    for (i in nums.indices) {
        var d = nums[i]
        sum += d
        cnt[d] ++
        if (cnt[d] == 1) {
            ans = Math.max(ans, sum)
            continue
        }

        while (l < i) {
            cnt[nums[l]] --
            sum -= nums[l]
            if (nums[l] == d) {
                l ++
                break
            }
            l++
        }
    }

    return ans
}


fun main() {
    println("Hello");
}
