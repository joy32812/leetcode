/**
 * binary search
 */
fun maxFrequencyScore(nums: IntArray, k: Long): Int {
    nums.sort()

    fun IntArray.toPresum(): LongArray {
        val presum = LongArray(this.size)
        presum[0] = this[0].toLong()
        for (i in 1 until this.size) {
            presum[i] = presum[i - 1] + this[i]
        }
        return presum
    }

    val presum = nums.toPresum()

    fun okay(l: Int, r: Int): Boolean {
        val m = (l + r) / 2
        val left = 1L * nums[m] * (m - l + 1) - (presum[m] - (if (l == 0) 0 else presum[l - 1]))
        val right = (presum[r] - presum[m]) - 1L * nums[m] * (r - m)

        return left + right <= k
    }

    var ans = 0
    for (i in nums.indices) {
        var l = i
        var r = nums.size - 1

        if (okay(l, r)) {
            ans = maxOf(ans, r - l + 1)
            continue
        }

        while (l < r) {
            val m = (l + r) / 2
            if (!okay(i, m)) {
                r = m
            } else {
                l = m + 1
            }
        }

        ans = maxOf(ans, l - i)
    }

    return ans
}
