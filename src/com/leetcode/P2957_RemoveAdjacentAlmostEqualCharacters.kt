/**
 * Greedy
 */
fun removeAlmostEqualCharacters(word: String): Int {
    var last = '@'
    var ans = 0

    fun Char.isAlmostEqual(c: Char): Boolean {
        return this == c || this == c + 1 || this == c - 1
    }

    for (c in word) {
        last = if (c.isAlmostEqual(last)) {
            ans++
            '@'
        } else {
            c
        }
    }

    return ans

}
