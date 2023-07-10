/**
 * dp with memoization
 */
fun minimumBeautifulSubstrings(s: String): Int {
    if (s.last() == '0') return -1

    val INF = 1_000_000_000
    val ansMap = mutableMapOf<String, Int>()

    fun isPowerOfFive(x: Int): Boolean {
        var y = x
        while (y % 5 == 0) y /= 5
        return y == 1
    }

    fun dfs(t: String): Int {
        if (t.startsWith('0')) return INF
        if (t.endsWith('0')) return INF

        if (t in ansMap) return ansMap[t]!!

        if (t == "") return 0

        var ans = INF

        for (i in 1..t.length) {
            val sub = t.substring(0, i)
            val num = sub.toInt(2)
            if (!isPowerOfFive(num)) continue

            val subAns = dfs(t.substring(i))
            ans = minOf(ans, subAns + 1)
        }

        ansMap[t] = ans

        return ansMap[t]!!
    }

    val ans = dfs(s)

    return if (ans >= INF) -1 else ans
}

fun main() {
    println(minimumBeautifulSubstrings("1011"))
    println(minimumBeautifulSubstrings("111"))
    println(minimumBeautifulSubstrings("0"))
}
