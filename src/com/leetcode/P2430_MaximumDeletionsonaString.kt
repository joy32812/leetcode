/**
 * double dp
 */
fun deleteString(s: String): Int {

    val n = s.length

    val lcs = Array(n + 1) { IntArray(n + 1) }
    val dp = IntArray(n)

    for (i in s.indices.reversed()) {
        dp[i] = 1

        for (j in i + 1 until n) {
            if (s[i] == s[j]) lcs[i][j] = lcs[i + 1][j + 1] + 1

            if (lcs[i][j] >= j - i) dp[i] = maxOf(dp[i], dp[j] + 1)
        }

    }

    return dp[0]

}
