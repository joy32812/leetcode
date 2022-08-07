/**
 * process backwards
 * find the biggest (smallest possible value)
 */
fun minimumReplacement(nums: IntArray): Long {

    var ans = 0L
    val n = nums.lastIndex
    var prev = nums.last()

    fun split(x: Int) {
        var cnt = x / prev
        if (x % prev != 0) {
            cnt ++
            prev = x / cnt
        }

        ans += cnt - 1
    }

    for (i in n - 1 downTo 0) {
        split(nums[i])
    }
    return ans

}

fun main() {
    println(minimumReplacement(intArrayOf(1,13,15,2,5,14,12,17)))
}
