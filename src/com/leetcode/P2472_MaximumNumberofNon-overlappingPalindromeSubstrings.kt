/**
 * Classic dp.
 */
fun maxPalindromes(s: String, k: Int): Int {

    val isPalindromes = Array(s.length) { BooleanArray(s.length) }
    for (x in 1 until s.length) {
        for (i in 0 until s.length - x) {
            val j = i + x
            if (s[i] == s[j]) {
                isPalindromes[i][j] = if (i + 1 > j - 1) true else isPalindromes[i + 1][j - 1]
            }
        }
    }

    val dp = Array(s.length) { 0 }

    for (i in s.indices) {
        dp[i] = maxOf(dp[i], if (i - 1 >= 0) dp[i - 1] else 0)

        for (j in i downTo 0) {
            if (i - j + 1 < k) continue
            if (isPalindromes[j][i]) {
                dp[i] = maxOf(dp[i], (if (j > 0) dp[j - 1] else 0) + 1)
            }
        }
    }

    return dp.maxOrNull()!!

}
