import java.util.*

/**
 * TreeMap
 */
fun secondGreaterElement(nums: IntArray): IntArray {

    val ans = Array(nums.size) { -1 }
    val treeMap = TreeMap<Int, MutableList<Int>>()
    for (i in nums.indices) {
        treeMap.getOrPut(nums[i]) { mutableListOf() }.add(i)
    }

    val keys = treeMap.keys.toList().sortedDescending()

    val idTreeSet = TreeSet<Int>()
    idTreeSet.add(nums.size)
    idTreeSet.add(nums.size + 1)

    for (k in keys) {
        for (i in treeMap[k]!!) {
            val ceil = idTreeSet.ceiling(i)

            idTreeSet.remove(ceil)
            val second = idTreeSet.ceiling(i)
            if (second < nums.size) ans[i] = nums[second]
            
            idTreeSet.add(ceil)
        }

        for (i in treeMap[k]!!) idTreeSet.add(i)
    }


    return ans.toIntArray()
}
