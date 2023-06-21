/**
 * ZipWithNext.
 */
fun longestSemiRepetitiveSubstring(s: String): Int {

    val n = s.length

    fun okay(t: String) = t.zipWithNext().count { it.first == it.second } <= 1

    var ans = 0
    for (i in 0 until n) {
        for (j in i until n) {
            if (okay(s.substring(i..j))) ans = maxOf(ans, j - i + 1)
        }
    }

    return ans
}

fun main() {
    println(longestSemiRepetitiveSubstring("52233"))
}
