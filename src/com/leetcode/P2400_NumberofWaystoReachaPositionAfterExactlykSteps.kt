import java.util.*


/**
 * DP + BFS
 */
fun numberOfWays(startPos: Int, endPos: Int, k: Int): Int {

    fun toKey(step: Int, pos: Int) = step* 100000 + pos + 2000
    fun Int.slitKey() = this / 100000 to this % 100000 - 2000

    val mod = 1_000_000_000 + 7
    val ansMap = mutableMapOf<Int, Long>()
    ansMap[toKey(0, startPos)] = 1


    val Q = LinkedList<Int>()
    val inQ = mutableSetOf<Int>()
    Q += toKey(0, startPos)
    inQ += toKey(0, startPos)

    while (Q.isNotEmpty()) {
        val now = Q.poll()
        inQ -= now
        val (step, pos) = now.slitKey()

        if (step >= k) continue

        val next1 = toKey(step + 1, pos + 1)
        val next2 = toKey(step + 1, pos - 1)

        if (Math.abs(pos + 1 - endPos) <= k - step - 1) {
            ansMap[next1] = ((ansMap[next1] ?: 0) + ansMap[now]!!) % mod
            if (next1 !in inQ) {
                Q += next1
                inQ += next1
            }
        }

        if (Math.abs(pos - 1 - endPos) <= k - step - 1) {
            ansMap[next2] = ((ansMap[next2] ?: 0) + ansMap[now]!!) % mod
            if (next2 !in inQ) {
                Q += next2
                inQ += next2
            }
        }
    }


    return ((ansMap[toKey(k, endPos)] ?: 0) % mod).toInt()
}
