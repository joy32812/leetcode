/**
 * sort.
 * 3 cases.
 */
fun minimizeSum(nums: IntArray): Int {
    nums.sort()
    val n = nums.size

    return minOf(
        nums.last() - nums[2],
        nums[n - 3] - nums[0],
        nums[n - 2] - nums[1]
    )


}
