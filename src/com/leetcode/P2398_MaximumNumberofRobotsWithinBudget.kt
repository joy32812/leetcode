import java.util.*

/**
 * Sliding window.
 */
fun maximumRobots(chargeTimes: IntArray, runningCosts: IntArray, budget: Long): Int {

    var ans = 0
    var j = 0

    var count = 0
    val treeMap = TreeMap<Int, Int>()
    var costSum = 0L

    fun add(x: Int, y: Int) {
        count ++
        treeMap[x] = (treeMap[x] ?: 0) + 1
        costSum += y
    }

    fun remove(x: Int, y: Int) {
        count --
        treeMap[x] = (treeMap[x] ?: 0) - 1
        costSum -= y

        if (treeMap[x] == 0) {
            treeMap.remove(x)
        }
    }

    fun total() = treeMap.lastKey() + count * costSum

    for (i in chargeTimes.indices) {
        j = maxOf(j, i)
        while (j < chargeTimes.size) {
            add(chargeTimes[j], runningCosts[j])
            if (total() > budget) {
                remove(chargeTimes[j], runningCosts[j])
                break
            }
            j ++
        }

        ans = maxOf(ans, j - i)

        if (j > i) {
            remove(chargeTimes[i], runningCosts[i])
        }
    }
    return ans
}

