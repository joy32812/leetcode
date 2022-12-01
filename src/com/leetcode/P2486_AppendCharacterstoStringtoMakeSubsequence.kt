/**
 * Greedy.
 */
fun appendCharacters(s: String, t: String): Int {

    var i = 0
    var j = 0

    while (i < s.length && j < t.length) {
        if (s[i] == t[j]) {
            i++
            j++
        } else {
            i++
        }
    }

    return t.length - j


}
