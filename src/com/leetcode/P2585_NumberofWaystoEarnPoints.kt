/**
 * Knapsack DP
 */
fun waysToReachTarget(target: Int, types: Array<IntArray>): Int {

    val mod = 1000000007

    val dp = Array(target + 1) { 0L }
    dp[0] = 1L

    for ((count, cost) in types) {

        for (j in target downTo 0) {
            if (dp[j] == 0L) continue

            for (k in 1..count) {
                if (j + k * cost > target) break
                dp[j + k * cost] = (dp[j + k * cost] + dp[j]) % mod
            }
        }
    }


    return (dp[target] % mod).toInt()

}
