/**
 * easy. brute force.
 */
fun findMaxK(nums: IntArray): Int {

    val numSet = nums.toSet()
    var ans = -1

    for (d in nums) {
        if (d <= 0) continue
        if (-d in numSet) {
            ans = maxOf(ans, d)
        }
    }

    return ans
}
