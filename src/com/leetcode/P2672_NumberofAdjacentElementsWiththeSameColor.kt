/**
 * Simple counting.
 */
fun colorTheArray(n: Int, queries: Array<IntArray>): IntArray {

    val colors = Array(n) { 0 }

    fun sameWithPrev(i: Int) = i - 1 >= 0 && colors[i - 1] == colors[i] && colors[i] != 0
    fun sameWithNext(i: Int) = i + 1 < n && colors[i + 1] == colors[i] && colors[i] != 0

    var last = 0
    fun doColor(i: Int, color: Int): Int {
        if (sameWithPrev(i)) last --
        if (sameWithNext(i)) last --

        colors[i] = color

        if (sameWithPrev(i)) last ++
        if (sameWithNext(i)) last ++

        return last
    }

    return queries.map { (i, color) -> doColor(i, color) }.toIntArray()
}
