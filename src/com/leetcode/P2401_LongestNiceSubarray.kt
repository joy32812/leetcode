/**
 * Sliding window
 */
fun longestNiceSubarray(nums: IntArray): Int {
    var ans = 1
    val bitset = mutableSetOf<Int>()

    fun okay(x: Int): Boolean {
        for (i in 0 until 30) {
            if (x and (1 shl i) == 0) continue
            if (i in bitset) return false
        }
        return true
    }

    fun add(x: Int) {
        for (i in 0 until 30) {
            if (x and (1 shl i) == 0) continue
            bitset += i
        }
    }

    fun remove(x: Int) {
        for (i in 0 until 30) {
            if (x and (1 shl i) == 0) continue
            bitset -= i
        }
    }

    var j = 0
    for (i in nums.indices) {
        while (j < nums.size && okay(nums[j])) {
            add(nums[j])
            j++
        }

        ans = maxOf(ans, j - i)
        remove(nums[i])
    }

    return ans
}
