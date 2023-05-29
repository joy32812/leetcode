/**
 * brute force with bitmasks.
 */
fun maxStrength(nums: IntArray): Long {

    val n = nums.size
    var ans = Long.MIN_VALUE


    for (i in 1 until (1 shl n)) {
        var prod = 1L
        for (j in 0 until n) {
            if (i and (1 shl j) != 0) {
                prod *= nums[j]
            }
        }
        ans = maxOf(ans, prod)
    }

    return ans
}
