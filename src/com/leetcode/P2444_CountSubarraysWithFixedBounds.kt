import java.util.*

/**
 * Double sliding windows.
 */
fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {

    val numList = nums.toMutableList()
    numList += Int.MAX_VALUE / 2

    var ans = 0L

    val treeMap1 = TreeMap<Int, Int>()
    var r1 = 0

    val treeMap2 = TreeMap<Int, Int>()
    var r2 = 0

    fun okay(map: TreeMap<Int, Int>) = map.isNotEmpty() && map.firstKey() == minK && map.lastKey() == maxK
    fun outRange(map: TreeMap<Int, Int>) = map.isNotEmpty() && (map.firstKey() < minK || map.lastKey() > maxK)

    fun remove(map: TreeMap<Int, Int>, key: Int) {
        map[key] = map[key]!! - 1
        if (map[key] == 0) map.remove(key)
    }

    for (i in numList.indices) {
        while (r1 < numList.size && !okay(treeMap1) && !outRange(treeMap1)) {
            treeMap1[numList[r1]] = treeMap1.getOrDefault(numList[r1], 0) + 1
            r1++
        }

        while (r2 < numList.size && !outRange(treeMap2)) {
            treeMap2[numList[r2]] = treeMap2.getOrDefault(numList[r2], 0) + 1
            r2++
        }
        if (okay(treeMap1)) ans += r2 - r1

        remove(treeMap1, numList[i])
        remove(treeMap2, numList[i])
    }

    return ans
}

fun main() {
    println(countSubarrays(intArrayOf(1,3,5,2,7,5), 1, 5))
    println(countSubarrays(intArrayOf(1, 1, 1, 1), 1, 1))
}
