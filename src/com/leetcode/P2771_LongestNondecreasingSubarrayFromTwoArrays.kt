/**
 * dp
 */
fun maxNonDecreasingLength(nums1: IntArray, nums2: IntArray): Int {
    val n = nums1.size

    val nums = nums1.zip(nums2).map { intArrayOf(it.first, it.second) }

    val dp = Array(n) { IntArray(2) { 0 } }
    var ans = 1

    dp[0][0] = 1
    dp[0][1] = 1

    for (i in 1 until n) {
        dp[i][0] = 1
        dp[i][1] = 1

        for (j in 0 until 2) {
            for (k in 0 until 2) {
                if (nums[i][j] >= nums[i - 1][k]) {
                    dp[i][j] = maxOf(dp[i][j], dp[i - 1][k] + 1)
                }
            }
        }

        ans = maxOf(ans, dp[i][0], dp[i][1])
    }

    return ans
}
