/**
 * dp.
 */
fun minOperations(s1: String, s2: String, x: Int): Int {
    val nums = s1.indices.filter { i -> s1[i] != s2[i] }
    val n = nums.size

    if (n == 0) return 0
    if (n % 2 == 1) return -1

    val dp = Array(n) { Array(n) { Int.MAX_VALUE } }
    fun dfs(l: Int, r: Int): Int {
        if (l > r) return 0
        if (dp[l][r] != Int.MAX_VALUE) return dp[l][r]

        var res = nums[l + 1] - nums[l] + dfs(l + 2, r)
        for (i in l + 1 .. r step 2) {
            res = minOf(
                res,
                x + dfs(l + 1, i - 1) + dfs(i + 1, r)
            )
        }


        dp[l][r] = res
        return res
    }

    return dfs(0, n - 1)
}
