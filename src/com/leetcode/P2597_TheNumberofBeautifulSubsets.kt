
fun beautifulSubsets(nums: IntArray, k: Int): Int {

    nums.sort()

    var count = 0

    fun MutableMap<Int, Int>.addToMap(d: Int) {
        this[d] = (this[d] ?: 0) + 1
    }

    fun MutableMap<Int, Int>.removeFromMap(d: Int) {
        this[d] = (this[d] ?: 0) - 1
        if (this[d] == 0) remove(d)
    }

    fun dfs(i: Int, Q: MutableMap<Int, Int>) {
        if (i == nums.size) {
            count ++
            return
        }

        // choose i
        if (Q.isEmpty() || nums[i] - k !in Q) {
            Q.addToMap(nums[i])
            dfs(i + 1, Q)
            Q.removeFromMap(nums[i])
        }

        // not choose i
        dfs(i + 1, Q)


    }

    dfs(0, mutableMapOf())
    return count - 1
}

fun main() {
    // [10,4,5,7,2,1]
    // 3
    println(
        beautifulSubsets(
            intArrayOf(10, 4, 5, 7, 2, 1),
            3
        )
    )
}
