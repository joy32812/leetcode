fun minimizeConcatenatedLength(words: Array<String>): Int {
    val n = words.size
    val dp = Array(n) { Array(26) { Array(26) { 1_000_000_000 } } }
    val first = words[0].first() - 'a'
    val last = words[0].last() - 'a'

    dp[0][first][last] = words[0].length

    for (i in 0 until n - 1) {

        val l = words[i + 1].first() - 'a'
        val r = words[i + 1].last() - 'a'

        for (j in 0 until 26) {
            for (k in 0 until 26) {
                if (dp[i][j][k] == 1_000_000_000) continue

                // j, k, l, r
                dp[i + 1][j][r] = minOf(
                    dp[i + 1][j][r],
                    dp[i][j][k] + words[i + 1].length + (if(k == l) -1 else 0)
                )

                // l, r, j, k
                dp[i + 1][l][k] = minOf(
                    dp[i + 1][l][k],
                    dp[i][j][k] + words[i + 1].length + (if(j == r) -1 else 0)
                )
            }
        }
    }

    var ans = 1_000_000_000
    for (i in 0 until 26) {
        for (j in 0 until 26) {
            ans = minOf(ans, dp[n - 1][i][j])
        }
    }

    return ans
}

fun main() {
    // Input: words = ["aa","ab","bc"]
    println(
        minimizeConcatenatedLength(
            arrayOf("aa", "ab", "bc")
        )
    )

    // Input: words = ["ab","b"]
    println(
        minimizeConcatenatedLength(
            arrayOf("ab", "b")
        )
    )


    // Input: words = ["aaa","c","aba"]
    println(
        minimizeConcatenatedLength(
            arrayOf("aaa", "c", "aba")
        )
    )

}
