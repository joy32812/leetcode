
fun canMakePalindromeQueries(s: String, queries: Array<IntArray>): BooleanArray {

    val n = s.length / 2

    val first = s.substring(0, n)
    val second = s.substring(n).reversed()

    if (first.toCharArray().sorted() != second.toCharArray().sorted()) {
        return queries.map { false }.toBooleanArray()
    }

    fun fixIndex(query: IntArray): IntArray {
        val (a, b, c, d) = query
        val nc = n - 1 - (c - n)
        val nd = n - 1 - (d - n)
        return intArrayOf(a, b, nd, nc)
    }

    val diff = Array(n) { 0 }
    for (i in 0 until n) {
        diff[i] = if (i - 1 >= 0) diff[i - 1] else 0
        if (first[i] != second[i]) {
            diff[i]++
        }
    }


    val firstCnts = Array(n) { IntArray(26) }
    val secondCnts = Array(n) { IntArray(26) }
    for (i in 0 until n) {
        if (i > 0) {
            for (j in 0 until 26) {
                firstCnts[i][j] = firstCnts[i - 1][j]
                secondCnts[i][j] = secondCnts[i - 1][j]
            }
        }

        firstCnts[i][first[i] - 'a']++
        secondCnts[i][second[i] - 'a']++
    }


    fun getSegs(query: IntArray): List<Pair<Int, Int>> {
        val (a, b, c, d) = query

        val lists = listOf(0, a, b, c, d, n).sorted()

        val segs = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until lists.size - 1) {
            segs += lists[i] to lists[i]
            segs += lists[i] + 1 to lists[i + 1] - 1
        }

        return segs
    }

    fun getCharCnts(from: Int, to: Int, isFirst: Boolean): IntArray {
        val cnts = IntArray(26)
        val cntsArr = if (isFirst) firstCnts else secondCnts

        if (from - 1 < 0) {
            for (i in 0 until 26) {
                cnts[i] = cntsArr[to][i]
            }
        } else {
            for (i in 0 until 26) {
                cnts[i] = cntsArr[to][i] - cntsArr[from - 1][i]
            }
        }
        return cnts
    }

    operator fun IntRange.contains(other: IntRange): Boolean {
        return this.first <= other.first && this.last >= other.last
    }

    fun segOk(seg: Pair<Int, Int>, query: IntArray): Boolean {
        val (from, to) = seg
        if (from > to) return true

        val (a, b, c, d) = query

        val firstRange = (a..b)
        val secondRange = (c..d)
        val curRange = (from..to)

        if (curRange in firstRange && curRange in secondRange) {
            return true
        }

        if (curRange !in firstRange && curRange !in secondRange) {
            val diffCnt = diff[to] - if (from - 1 >= 0) diff[from - 1] else 0
            return diffCnt == 0
        }

        val firstCharCnts = if (from >= a && to <= b) {
            getCharCnts(a, b, true)
        } else {
            getCharCnts(from, to, true)
        }

        val secondCharCnts = if (from >= c && to <= d) {
            getCharCnts(c, d, false)
        } else {
            getCharCnts(from, to, false)
        }

        return (0 until 26).all { firstCharCnts[it] <= secondCharCnts[it] } || (0 until 26).all { firstCharCnts[it] >= secondCharCnts[it] }
    }


    val newQueries = queries.map { fixIndex(it) }
    fun canMakePalindrome(query: IntArray): Boolean {
        val segs = getSegs(query)
        return segs.all { segOk(it, query) }
    }

    return newQueries.map { canMakePalindrome(it) }.toBooleanArray()

}

