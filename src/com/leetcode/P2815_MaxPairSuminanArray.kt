fun maxSum(nums: IntArray): Int {

    var ans = -1
    fun Int.toMaxDigit() = toString().map { it - '0' }.maxOrNull() ?: 0

    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i].toMaxDigit() == nums[j].toMaxDigit()) ans = maxOf(ans, nums[i] + nums[j])
        }
    }

    return ans
}
