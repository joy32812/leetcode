/**
 * brute force
 */
fun maximumTripletValue(nums: IntArray): Long {
    val n = nums.size
    var ans = 0L

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            for (k in j + 1 until n) {
                val product = 1L * (nums[i] - nums[j]) * nums[k]
                ans = maxOf(ans, product)
            }
        }
    }

    return ans
}
