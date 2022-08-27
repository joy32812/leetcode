import java.util.*

fun maximumSegmentSum(nums: IntArray, removeQueries: IntArray): LongArray {

    var max = 0L
    val sumMap = mutableMapOf<Int, Long>()

    val treeMap = TreeMap<Int, Int>()


    fun findSum(x: Int): Long {

        var l = x
        var r = x
        var cursum = 0L + nums[x]

        // floor
        val floor = treeMap.floorEntry(x - 1)
        if (floor != null && floor.value + 1 == x) {
            l = floor.key
            cursum += sumMap[l] ?: 0
            sumMap.remove(l)
            treeMap.remove(l)
        }

        // ceiling
        val ceiling = treeMap.ceilingEntry(x + 1)
        if (ceiling != null && x + 1 == ceiling.key) {
            r = ceiling.value
            val key = ceiling.key
            cursum += sumMap[key] ?: 0
            sumMap.remove(key)
            treeMap.remove(key)
        }

        sumMap[l] = cursum
        treeMap[l] = r
        val tmpmax = max

        max = maxOf(max, cursum)
        return tmpmax
    }


    return removeQueries.reversed().map {
        findSum(it)
    }.reversed().toLongArray()
}

fun main() {
    println(maximumSegmentSum(
        intArrayOf(500,822,202,707,298,484,311,680,901,319,343,340),
        intArrayOf(6,4,0,5,2,3,10,8,7,9,1,11)
    ))
}
