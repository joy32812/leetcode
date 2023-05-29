/**
 * classic dp.
 * Top down with memoization.
 */
fun minExtraChar(s: String, dictionary: Array<String>): Int {

    val dictSet = dictionary.toSet()
    val dp = IntArray(s.length) { Int.MAX_VALUE }

    fun dfs(i: Int): Int {
        if (i < 0) return 0
        if (dp[i] != Int.MAX_VALUE) return dp[i]

        for (j in 0..i) {
            val sub = s.substring(j, i + 1)
            if (dictSet.contains(sub)) {
                dp[i] = minOf(dp[i], dfs(j - 1))
            } else {
                dp[i] = minOf(dp[i], dfs(j - 1) + sub.length)
            }
        }

        return dp[i]
    }

    return dfs(s.length - 1)
}
