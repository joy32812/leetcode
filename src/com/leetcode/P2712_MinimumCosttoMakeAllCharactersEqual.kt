/**
 * invert from the middle.
 */
fun minimumCost(s: String): Long {

    val n = s.length

    fun setLeft(x: Int, target: Int): Long {
        var ans = 0L
        var invertCnt = 0

        for (i in x downTo 0) {
            val now = ((s[i] - '0') + invertCnt) % 2
            if (now != target) {
                invertCnt ++
                ans += i + 1
            }
        }

        return ans
    }

    fun setRight(x: Int, target: Int): Long {
        var ans = 0L
        var invertCnt = 0

        for (i in x until n) {
            val now = ((s[i] - '0') + invertCnt) % 2
            if (now != target) {
                invertCnt ++
                ans += n - i
            }
        }

        return ans
    }

    return minOf(
        setLeft(n /2 - 1, 0) + setRight(n / 2, 0),
        setLeft(n /2 - 1, 1) + setRight(n / 2, 1)
    )

}
