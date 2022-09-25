/**
 * down1: max length of the longest decreasing subsequence ending at i
 * down2: max length of the longest increasing subsequence starting at i
 */
fun goodIndices(nums: IntArray, k: Int): List<Int> {
    val n = nums.size

    val down1 = IntArray(n)
    for (i in nums.indices) {
        if (i - 1 >= 0 && nums[i] <= nums[i - 1]) {
            down1[i] = down1[i - 1] + 1
        } else {
            down1[i] = 1
        }
    }

    val down2 = IntArray(n)
    for (i in nums.indices.reversed()) {
        if (i + 1 < n && nums[i] <= nums[i + 1]) {
            down2[i] = down2[i + 1] + 1
        } else {
            down2[i] = 1
        }
    }

    return (1 until n - 1).filter { down1[it - 1] >= k && down2[it + 1] >= k }
}
