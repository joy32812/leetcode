/**
 * Classic dp.
 */
fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {

    val mod = 1000000007
    var ans = 0L
    val dp = Array(high + 1) { 0L }

    dp[0] = 1L

    for (i in 1..high) {
        if (i - zero >= 0) dp[i] = (dp[i] + dp[i - zero]) % mod
        if (i - one >= 0) dp[i] = (dp[i] + dp[i - one]) % mod

        if (i >= low) ans = (ans + dp[i]) % mod
    }

    return ans.toInt()
}
