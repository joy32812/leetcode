/**
 * DP.
 */
fun palindromePartition(s: String, k: Int): Int {
    val n = s.length
    val mins = Array(n) { IntArray(n) { Int.MAX_VALUE } }

    for (i in s.indices) {
        for (j in i until s.length) {
            var l = i
            var r = j
            var cnt = 0
            while (l < r) {
                if (s[l] != s[r]) cnt ++
                l++
                r--
            }
            mins[i][j] = minOf(mins[i][j], cnt)
        }
    }

    val ansMap = mutableMapOf<Pair<Int, Int>, Int>()
    fun dfs(x: Int, z: Int): Int {
        if (x + 1 == z) return 0
        if (x + 1 < z) return Int.MAX_VALUE / 2
        if (z == 1) return mins[0][x]

        val p = Pair(x, z)
        if (p in ansMap) return ansMap[p]!!

        var ans = Int.MAX_VALUE

        for (i in 1..x + 1) {
            ans = minOf(ans, mins[x - i + 1][x] + dfs(x - i, z - 1))
        }

        ansMap[p] = ans
        return ans
    }

    return dfs(s.length - 1, k)

}

