/**
 * union find.
 */
fun findTheString(lcp: Array<IntArray>): String {
    val n = lcp.size

    val father = IntArray(n) { -1 }
    fun getFather(i: Int): Int {
        if (father[i] == -1) return i
        father[i] = getFather(father[i])
        return father[i]
    }

    val nonEqualPairs = mutableListOf<Pair<Int, Int>>()

    fun check(i: Int, j: Int, v: Int) {

        for (k in 0 until v) {
            val fi = getFather(i + k)
            val fj = getFather(j + k)
            if (fi != fj) {
                father[fi] = fj
            }
        }

        if (i + v < n && j + v < n) {
            nonEqualPairs.add(i + v to j + v)
        }
    }

    for (i in lcp.indices) {
        for (j in lcp[0].indices) {
            if (i == j && lcp[i][j] != n - i) {
                return ""
            }

            if (i + lcp[i][j] > n || j + lcp[i][j] > n) {
                return ""
            }

            check(i, j, lcp[i][j])
        }
    }

    if (nonEqualPairs.any { getFather(it.first) == getFather(it.second) }) {
        return ""
    }


    val ans = mutableListOf<Char>()
    for (i in 0 until n) {
        val noSet = mutableSetOf<Char>()

        var found = false
        for (j in 0 until i) {
            val fi = getFather(i)
            val fj = getFather(j)

            if (fi == fj) {
                found = true
                ans += ans[j]
                break
            } else {
                noSet += ans[j]
            }
        }

        if (found) continue

        val first = ('a'..'z').firstOrNull { it !in noSet } ?: return ""
        ans.add(first)
    }

    return ans.joinToString("")
}
