/**
 * [XY]A[YX]
 *
 * iterate by A.
 * Sum of the cnt of XY (00-99)
 */
fun countPalindromes(s: String): Int {
    if (s.length < 5) return 0

    val mod = 1000000007

    val right = mutableMapOf<Int, Long>()
    val left = mutableMapOf<Int, Long>()

    val rightCnt = Array(10) { 0 }
    val leftCnt = Array(10) { 0 }

    for (i in s.indices.reversed()) {

        for (j in 0 until 10) {
            val key = (s[i] - '0') * 10 + j
            right[key] = (right.getOrDefault(key, 0) + rightCnt[j]) % mod
        }

        rightCnt[s[i] - '0']++
    }

    var ans = 0L
    for (i in s.indices) {
        rightCnt[s[i] - '0']--
        for (j in 0 until 10) {
            val key = (s[i] - '0') * 10 + j
            right[key] = (mod + right.getOrDefault(key, 0) - rightCnt[j]) % mod
        }

        if (i >= 2 && i < s.length - 2) {
            for (p in 0 until 100) {
                val q = p % 10 * 10 + p / 10
                ans = (ans + left.getOrDefault(p, 0) * right.getOrDefault(q, 0)) % mod
            }
        }

        for (j in 0 until 10) {
            val key = j * 10 + (s[i] - '0')
            left[key] = (left.getOrDefault(key, 0) + leftCnt[j]) % mod
        }

        leftCnt[s[i] - '0']++
    }

    return ans.toInt()
}

fun main() {
    println(countPalindromes("103301"))
}
