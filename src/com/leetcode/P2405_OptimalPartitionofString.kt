/**
 * greedy
 */
fun partitionString(s: String): Int {

    var cnt = 0
    val set = mutableSetOf<Char>()
    for (c in s) {
        if (c in set) {
            cnt++
            set.clear()
        }

        set += c
    }

    return cnt + 1
}
