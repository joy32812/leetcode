/**
 * preSum
 * indexOfFirst
 */
fun answerQueries(nums: IntArray, queries: IntArray): IntArray {

    nums.sort()
    val presum = IntArray(nums.size)
    for (i in nums.indices) presum[i] = (if (i - 1 < 0) 0 else presum[i - 1]) + nums[i]

    fun work(d: Int) = if (presum.last() <= d) nums.size else presum.indexOfFirst { it > d }

    return queries.map { work(it) }.toIntArray()

}
