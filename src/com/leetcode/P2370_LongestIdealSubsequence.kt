/**
 * dp
 */
fun longestIdealString(s: String, k: Int): Int {

    val dp = Array(s.length) { 1 }
    val posMap = mutableMapOf<Char, Int>()
    posMap[s[0]] = 0

    for (i in 1 until s.length) {

        for (c in 'a'..'z') {
            if (Math.abs(c - s[i]) > k) continue
            if (c !in posMap) continue

            dp[i] = Math.max(dp[i], dp[posMap[c]!!] + 1)
        }

        posMap[s[i]] = i
    }

    return dp.maxOrNull() ?: 0

}
