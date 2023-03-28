/**
 * sortWith and greedy.
 */
fun findScore(nums: IntArray): Long {

    val pairs = nums.indices.map { i -> nums[i] to i }.sortedWith(compareBy({ it.first }, { it.second }))

    val markSet = mutableSetOf<Int>()

    var ans = 0L

    for ((d, i) in pairs) {

        if (i in markSet) continue

        ans += d

        markSet += i
        markSet += i - 1
        markSet += i + 1
    }


    return ans
}
