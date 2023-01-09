import java.util.LinkedList

/**
 * Slide window.
 */
class DataStream(value: Int, k: Int) {
    val V = value
    val N = k
    val list = LinkedList<Int>()
    val cntMap = mutableMapOf<Int, Int>()

    fun consec(num: Int): Boolean {
        list += num
        cntMap[num] = cntMap.getOrDefault(num, 0) + 1

        if (list.size > N) {
            val first = list.removeFirst()

            cntMap[first] = cntMap[first]!! - 1
            if (cntMap[first] == 0) cntMap.remove(first)
        }

        return cntMap == mapOf(V to N)
    }
}

