/**
 * Knapsack DP.
 */
fun countSubMultisets(nums: List<Int>, l: Int, r: Int): Int {

    val mod = 1_000_000_007
    val zeroCnt = nums.count { it == 0 }
    val cntMap = nums.groupBy { it }.mapValues { it.value.size }.filter { it.key != 0 }
    val keys = cntMap.keys.sorted()

    val dp = LongArray(r + 1) { 0L }
    dp[0] = 1L

    var upper = 0
    for (k in keys) {
        val cnt = cntMap[k]!!

        for (i in upper downTo 0) {
            if (dp[i] == 0L) continue

            for (j in 1..cnt) {
                if (i + k * j > r) break
                upper = maxOf(upper, i + k * j)
                dp[i + k * j] = (dp[i + k * j] + dp[i]) % mod
            }
        }
    }

    var ans = 0L
    for (i in l..r) {
        ans = (ans + dp[i]) % mod
    }
    ans = (ans * (zeroCnt + 1L)) % mod
    return ans.toInt()
}
