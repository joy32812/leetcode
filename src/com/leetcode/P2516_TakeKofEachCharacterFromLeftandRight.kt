/**
 * Sliding window.
 */
fun takeCharacters(s: String, k: Int): Int {
    if (k == 0) return 0

    val counts = IntArray(3)

    var l = -1
    var r = 0
    for (i in s.indices.reversed()) {
        counts[s[i] - 'a']++

        if (counts.all { it >= k }) {
            l = i
            break
        }
    }

    if (l == -1) return -1

    var ans = s.length - l
    while (r < s.length) {

        counts[s[r] - 'a']++
        r++

        while (l < s.length && counts[s[l] - 'a'] > k) {
            counts[s[l] - 'a']--
            l++
        }

        ans = minOf(ans, s.length - l + r)
    }


    return ans
}
