/**
 * Get the result of and operation of all elements
 * 1. result ! = 0, means we can't have more than 2 subarrays
 * 2. result == 0, means `and` result for each subarray must be 0 too
 */
fun maxSubarrays(nums: IntArray): Int {
    // Get the result of and operation of all elements
    val andVal = nums.reduce { acc, i -> acc and i }
    if (andVal != 0) return 1

    var ans = 0
    var now = (1 shl 30) - 1
    for (i in nums.indices) {
        if (now and nums[i] == 0) {
            ans ++
            now = (1 shl 30) - 1
        } else {
            now = now and nums[i]
        }
    }

    return ans
}
