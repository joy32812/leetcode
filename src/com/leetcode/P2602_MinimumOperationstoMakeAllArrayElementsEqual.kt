@file:JvmName("P2601_PrimeSubtractionOperationKt")

fun minOperations(nums: IntArray, queries: IntArray): List<Long> {

    nums.sort()
    val presum = LongArray(nums.size)
    presum[0] = nums[0].toLong()
    for (i in 1 until nums.size) {
        presum[i] = presum[i - 1] + nums[i]
    }

    // binary search to find the insertion point
    fun bs(q: Int): Int {
        var l = 0
        var r = nums.size
        while (l < r) {
            val m = (l + r) / 2
            if (nums[m] >= q) r = m
            else l = m + 1
        }
        return l
    }

    fun work(q: Int): Long {
        if (q <= nums[0]) {
            return presum.last() - 1L * q * nums.size
        }
        if (q >= nums.last()) {
            return 1L * q * nums.size - presum.last()
        }

        val idx = bs(q)

        val ll = 1L * q * idx - presum[idx - 1]
        val rr = presum.last() - presum[idx - 1] - 1L * q * (nums.size - idx)

        return ll + rr
    }

    return queries.map { work(it) }
}

fun main() {
//    nums = [3,1,6,8], queries = [1,5]
    println(minOperations(
        intArrayOf(3,1,6,8),
        intArrayOf(1,5)
    ))
}
