/**
 * greedy.
 */
fun maximizeGreatness(nums: IntArray): Int {

    nums.sort()

    val list = nums.sorted()
    var j = 0
    var ans = 0

    for (d in nums) {
        while (j < list.size && list[j] <= d) j ++
        if (j == list.size) break

        ans ++
        j ++
    }

    return ans
}

fun main() {
    println(maximizeGreatness(
        intArrayOf(1,3,5,2,1,3,1)
    ))
}
