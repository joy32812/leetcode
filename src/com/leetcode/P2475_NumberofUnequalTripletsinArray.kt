/**
 * brute force.
 */
fun unequalTriplets(nums: IntArray): Int {

    var ans = 0
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            for (k in j + 1 until nums.size) {
                if (setOf(nums[i], nums[j], nums[k]).size == 3) ans ++
            }
        }
    }

    return ans
}
