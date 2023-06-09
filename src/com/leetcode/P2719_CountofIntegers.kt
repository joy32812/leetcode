/**
 * digit dp.
 */
fun count(num1: String, num2: String, min_sum: Int, max_sum: Int): Int {

    // dp[22][4][10][400]
    // i: index
    // m: mask
    // mask 0: == num1[i] && == num2[i]
    // mask 1: == num1[i] && != num2[i]
    // mask 2: != num1[i] && == num2[i]
    // mask 3: != num1[i] && != num2[i]
    // j: current digit
    // k: digit sum

    val mod = 1000000007
    val n = Math.max(num1.length, num2.length) + 1
    val dp = Array(n) { Array(4) { Array(10) { LongArray(max_sum + 1) } } }

    val num1 = num1.padStart(n, '0')
    val num2 = num2.padStart(n, '0')

    dp[0][0][0][0] = 1

    for (i in 0 until n - 1) {
        val d1 = num1[i + 1] - '0'
        val d2 = num2[i + 1] - '0'

        for (m in 0 until 4) {
            for (j in 0 until 10) {
                for (k in 0 .. max_sum) {

                    if (m == 0) {
                        for (y in d1 .. d2) {
                            val nm = if (y == d1 && y == d2) 0 else if (y == d1) 1 else if (y == d2) 2 else 3
                            if (k + y <= max_sum) {
                                dp[i + 1][nm][y][k + y] += dp[i][m][j][k]
                                dp[i + 1][nm][y][k + y] = dp[i + 1][nm][y][k + y] % mod
                            }
                        }
                    } else if (m == 1) {

                        for (y in d1 until 10) {
                            val nm = if (y == d1) 1 else 3
                            if (k + y <= max_sum) {
                                dp[i + 1][nm][y][k + y] += dp[i][m][j][k]
                                dp[i + 1][nm][y][k + y] = dp[i + 1][nm][y][k + y] % mod
                            }
                        }
                    } else if (m == 2) {

                        for (y in 0 .. d2) {
                            val nm = if (y == d2) 2 else 3
                            if (k + y <= max_sum) {
                                dp[i + 1][nm][y][k + y] += dp[i][m][j][k]
                                dp[i + 1][nm][y][k + y] = dp[i + 1][nm][y][k + y] % mod
                            }
                        }
                    } else {

                        for (y in 0 until 10) {
                            val nm = 3
                            if (k + y <= max_sum) {
                                dp[i + 1][nm][y][k + y] += dp[i][m][j][k]
                                dp[i + 1][nm][y][k + y] = dp[i + 1][nm][y][k + y] % mod
                            }
                        }

                    }
                }
            }
        }
    }

    var ans = 0L

    for (m in 0 until 4) {
        for (j in 0 until 10) {
            for (k in min_sum .. max_sum) {
                ans += dp[n - 1][m][j][k]
                ans %= mod
            }
        }
    }


    return ans.toInt()
}

fun main() {
    // "1"
    //"12"
    //1
    //8
    println(count("1", "12", 1, 8))
}
