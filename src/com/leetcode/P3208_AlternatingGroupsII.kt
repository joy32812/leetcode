// Greedy algorithm.
fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
    // merge the array with itself to avoid checking the boundaries
    val arr = colors + colors

    val n = arr.size
    val dp = Array(n) { 1 }

    for (i in n - 2 downTo 0) {
        if (arr[i] != arr[i + 1]) {
            dp[i] = dp[i + 1] + 1
        }
    }

    return colors.indices.count { dp[it] >= k }
}
