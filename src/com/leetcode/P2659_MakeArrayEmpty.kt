
fun countOperationsToEmptyArray(nums: IntArray): Long {
    val n = nums.size
    val BIT = Array(n + 1) { 0L }

    fun lowbit(x: Int): Int {
        return x and -x
    }

    fun add(x: Int, v: Long) {
        var i = x
        while (i <= n) {
            BIT[i] += v
            i += lowbit(i)
        }
    }

    fun sum(x: Int): Long {
        var i = x
        var ans = 0L
        while (i > 0) {
            ans += BIT[i]
            i -= lowbit(i)
        }
        return ans
    }


    for (i in nums.indices) {
        add(i + 1, 1)
    }

    val sorted = nums.withIndex().sortedBy { it.value }

    var ans = 0L
    var last = 0
    for ((i, _) in sorted) {

        if (i >= last) {
            ans += sum(i + 1) - sum(last)
        } else {
            ans += sum(n) - sum(last) + sum(i + 1)
        }

        add(i + 1, -1)
        last = i
    }


    return ans
}

fun main() {
    //    Input: nums = [3,4,-1]
//    println(countOperationsToEmptyArray(intArrayOf(3, 4, -1)))
    // [1,2,4,3]
    println(countOperationsToEmptyArray(intArrayOf(1, 2, 4, 3)))

}
