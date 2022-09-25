/**
 * easy
 */
fun longestContinuousSubstring(s: String): Int {

    var ans = 1

    var lastChar = '@'
    var last = 0

    for (c in s) {

        if (c == lastChar + 1) {
            ans = maxOf(ans, last + 1)
            last ++
        } else {
            last = 1
        }

        lastChar = c
    }

    return ans
}
