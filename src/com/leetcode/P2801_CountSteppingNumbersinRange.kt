/**
 * 0: means real 0, not all previous digits are 0
 * 10: means all previous digits are 0
 */
fun countSteppingNumbers(low: String, high: String): Int {
    val mod = 1_000_000_007

    fun String.isSN() = zipWithNext().all { Math.abs(it.first - it.second) == 1 }
    fun Char.toI() = this - '0'

    fun getSNCnt(x: String): Int {
        val n = x.length
        val dp = Array(n) { Array(11) { LongArray(2) } }

        dp[0][10][0] = 1
        for (j in 1 until x[0].toI()) dp[0][j][0] = 1
        dp[0][x[0].toI()][1] = 1

        for (i in 0 until n - 1) {
            dp[i + 1][10][0] = 1

            val nd = x[i + 1].toI()
            for (j in 0 until 11) {
                for (k in 0 until 2) {
                    val z = j % 10

                    for (t in 0 until 10) {
                        if (j == 10 && t == 0) continue

                        if (j == 10 || t == z - 1 || t == z + 1) {
                            if (k == 0) {
                                dp[i + 1][t][0] = (dp[i + 1][t][0] + dp[i][j][k]) % mod
                            } else {
                                if (t < nd) {
                                    dp[i + 1][t][0] = (dp[i + 1][t][0] + dp[i][j][k]) % mod
                                } else if (t == nd) {
                                    dp[i + 1][t][1] = (dp[i + 1][t][1] + dp[i][j][k]) % mod
                                }
                            }
                        }
                    }
                }
            }
        }

        return (dp[n - 1].sumOf { it.sum() } % mod).toInt()
    }

    val highCnt = getSNCnt(high)
    val lowCnt = getSNCnt(low)
    return (highCnt - lowCnt + (if (low.isSN()) 1 else 0) + mod) % mod
}

fun main() {
    println(countSteppingNumbers("1", "11"))
    println(countSteppingNumbers("90", "101"))
}
