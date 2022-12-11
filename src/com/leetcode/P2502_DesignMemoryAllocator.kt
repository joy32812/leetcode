import java.util.*

/**
 * TreeMap
 */
class Allocator(n: Int) {

    val allocMap = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    val freeMap = TreeMap<Int, Int>()
    init {
        freeMap[0] = n - 1
    }

    fun allocate(size: Int, mID: Int): Int {
        for ((start, end) in freeMap) {
            if (end - start + 1 >= size) {
                freeMap.remove(start)
                if (start + size <= end) freeMap[start + size] = end

                allocMap.getOrPut(mID) { mutableListOf() }.add(start to start + size - 1)

                return start
            }
        }
        return -1

    }

    fun merge(l: Int, r: Int) {
        var ll = l
        var rr = r

        val floor = freeMap.floorEntry(ll - 1)
        if (floor != null && floor.value + 1 == ll) {
            freeMap.remove(floor.key)
            ll = floor.key
        }

        val ceiling = freeMap.ceilingEntry(rr + 1)
        if (ceiling != null && ceiling.key - 1 == rr) {
            freeMap.remove(ceiling.key)
            rr = ceiling.value
        }

        freeMap[ll] = rr
    }

    fun free(mID: Int): Int {
        if (mID !in allocMap) return 0

        var ans = 0
        for ((start, end) in allocMap[mID]!!) {
            ans += end - start + 1
            merge(start, end)
        }

        allocMap.remove(mID)

        return ans
    }

}

fun main() {
    // ["Allocator","allocate","allocate","allocate","free","free","allocate","free","allocate"]
    // [[7],[7,8],[8,7],[6,2],[9],[8],[7,6],[9],[10,9]]
    val allocator = Allocator(7)
    println(allocator.allocate(7, 8))
    println(allocator.allocate(8, 7))
    println(allocator.allocate(6, 2))
    println(allocator.free(9))
    println(allocator.free(8))
    println(allocator.allocate(7, 6))
}
