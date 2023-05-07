/**
 * Compare left and right. Smaller one needs to catch up.
 */
fun minIncrements(n: Int, cost: IntArray): Int {
    var ans = 0

    fun dfs(x: Int): Int {
        if (x >= n) return 0

        val left = dfs(2 * x + 1)
        val right = dfs(2 * x + 2)

        ans += Math.abs(left - right)
        return maxOf(left, right) + cost[x]
    }

    dfs(0)

    return ans
}

fun main() {
    // Input: n = 7, cost = [1,5,2,2,3,3,1]
    println(minIncrements(7, intArrayOf(1, 5, 2, 2, 3, 3, 1)))
}
