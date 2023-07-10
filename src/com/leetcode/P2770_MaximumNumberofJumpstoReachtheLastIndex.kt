/**
 * classic dp
 */
fun maximumJumps(nums: IntArray, target: Int): Int {

    val n = nums.size
    val dp = Array(n) { -1 }
    dp[0] = 0

    for (i in 0 until n) {
        if (dp[i] == -1) continue

        for (j in i + 1 until n) {
            if (Math.abs(nums[i] - nums[j]) <= target) {
                dp[j] = maxOf(dp[j], dp[i] + 1)
            }
        }
    }


    return dp[n - 1]
}

fun main() {
    // [0,2,1,3], 1
    println(maximumJumps(
        intArrayOf(0, 2, 1, 3),
        1
    ))
}
