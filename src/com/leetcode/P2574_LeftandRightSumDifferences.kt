/**
 * easy.
 */
fun leftRigthDifference(nums: IntArray): IntArray {
    var left = 0
    var right = nums.sum()

    var result = IntArray(nums.size)

    for (i in nums.indices) {
        right -= nums[i]
        result[i] = Math.abs(left - right)
        left += nums[i]
    }

    return result
}
