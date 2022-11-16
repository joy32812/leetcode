import java.util.*

/**
 * Priority Queue.
 */
data class Tc(val cost: Int, val index: Int)
fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {

    var l = 0
    var r = costs.size - 1

    val pq = PriorityQueue<Tc> { a, b -> if (a.cost == b.cost) a.index - b.index else a.cost - b.cost }

    while (l <= r && l < candidates) {
        pq.add(Tc(costs[l], l))
        if (l < r) {
            pq.add(Tc(costs[r], r))
        }
        l ++
        r --
    }

    var ans = 0L
    for (i in 0 until k) {
        val tc = pq.poll()
        ans += tc.cost

        val index = tc.index

        if (index < l) {
            if (l <= r) {
                pq.add(Tc(costs[l], l))
                l ++
            }
        } else {
            if (r >= l) {
                pq.add(Tc(costs[r], r))
                r --
            }
        }
    }

    return ans
}
