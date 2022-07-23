/**
 * P(x) means we have all the possible len x sequences.
 * If we want to get P(x + 1), we need to have another set of [1..k]
 */
fun shortestSequence(rolls: IntArray, k: Int): Int {
    var ans = 1
    val set = mutableSetOf<Int>()

    for (d in rolls) {
        set += d

        if (set.size == k) {
            ans++
            set.clear()
        }
    }

    return ans
}
