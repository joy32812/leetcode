/**
 * maximum length of the subarray with the same number.
 */
fun longestSubarray(nums: IntArray): Int {

    val max = nums.maxByOrNull { it }!!

    var ans = 0
    var last = 0
    for (i in nums.indices) {

        if (nums[i] == max) {
            ans = maxOf(ans, last + 1)
            last ++
        } else {
            last = 0
        }

    }
    return ans

}
