/**
 * Knapsack dp
 */
fun paintWalls(cost: IntArray, time: IntArray): Int {

  val n = cost.size

  val dp = Array(n) { Array(n + 1) { Long.MAX_VALUE } }

  fun dfs(i: Int, x: Int): Long {
    if (x <= 0) return 0
    if (i == n) return Int.MAX_VALUE.toLong()

    if (dp[i][x] != Long.MAX_VALUE) return dp[i][x]

    val res = minOf(
      dfs(i + 1, x),
      cost[i] + dfs(i + 1, x - time[i] - 1)
    )

    dp[i][x] = res
    return res
  }

  return dfs(0, n).toInt()
}
