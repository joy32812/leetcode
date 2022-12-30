/**
 * DP
 */
fun countPartitions(nums: IntArray, k: Int): Int {
    val n = nums.size
    val mod = 1_000_000_007
    val sum = nums.map { it.toLong() }.sum()
    if (sum < 2 * k) return 0

    val D = listOf(0) + nums.toList()

    val dp = Array(n + 1) { Array(k) { 0L } }
    dp[0][0] = 1

    for (i in 1 until D.size) {
        // No D[i]
        for (j in dp[i].indices) {
            dp[i][j] = dp[i - 1][j]
        }

        // D[i]
        for (j in dp[i].indices) {
            val V = j + D[i]
            if (V >= k) continue
            dp[i][V] = (dp[i][V] + dp[i - 1][j]) % mod
        }
    }

    fun getTotal(): Long {
        var ans = 1L
        repeat(nums.size) {
            ans = (ans * 2) % mod
        }
        return ans
    }

    return ((getTotal() - 2 * dp[n].sum() % mod + mod) % mod).toInt()
}

