fun longestString(x: Int, y: Int, z: Int): Int {
    val dp = Array(3) { Array(x + 1) { Array(y + 1) { Array(z + 1) { -1 } } } }

    fun dfs(state: Int, a: Int, b: Int, c: Int): Int {
        if (a == 0 && b == 0 && c == 0) return 0
        if (dp[state][a][b][c] != -1) return dp[state][a][b][c]

        val ans =
            if (state == 0) {
                if (b == 0) 0 else 2 + dfs(1, a, b - 1, c)
            } else if (state == 1) {
                maxOf(
                    if (c == 0) 0 else 2 + dfs(2, a, b, c - 1),
                    if (a == 0) 0 else 2 + dfs(0, a - 1, b, c)
                )
            } else {
                maxOf(
                    if (a == 0) 0 else 2 + dfs(0, a - 1, b, c),
                    if (c == 0) 0 else 2 + dfs(2, a, b, c - 1)
                )
            }

        dp[state][a][b][c] = ans

        return ans
    }

    return maxOf(
        dfs(0, x, y, z),
        dfs(1, x, y, z),
        dfs(2, x, y, z)
    )

}

fun main() {
    println(longestString(1, 39, 14))
//    println(longestString(2, 5, 1))
//    println(longestString(3, 2, 2))
}
