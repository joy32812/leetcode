fun alternatingSubarray(nums: IntArray): Int {

    fun find(i: Int): Int {
        if (i + 1 >= nums.size) return 1

        var j = i + 1
        while (j < nums.size) {
            val diff = j - i
            if (nums[j] != nums[i] + (diff % 2)) break

            j ++
        }

        return j - i
    }

    val ans = nums.indices.maxOfOrNull { find(it) } ?: 0
    return if (ans == 1) -1 else ans
}

fun main() {
    println(alternatingSubarray(
        intArrayOf(2,3,4,3,4)
    ))
}
