/**
 * find left max position and right min position
 */
fun minimumScore(s: String, t: String): Int {
    val left = Array(s.length) { -1 }

    var p = -1
    for (i in s.indices) {
        if (i - 1 >= 0) left[i] = left[i - 1]

        if (p + 1 < t.length && s[i] == t[p + 1]) {
            p ++
            left[i] = p
        }
    }

    val right = Array(s.length) { t.length }

    p = t.length
    for (i in s.length - 1 downTo 0) {
        if (i + 1 < s.length) right[i] = right[i + 1]

        if (p - 1 >= 0 && s[i] == t[p - 1]) {
            p --
            right[i] = p
        }
    }

    if (left[s.length - 1] == t.length - 1) return 0

    var ans = right[0]
    for (i in s.indices) {
        val l = left[i]
        val r = if (i + 1 < s.length) right[i + 1] else t.length

        ans = minOf(ans, r - l - 1)
    }

    return ans
}
