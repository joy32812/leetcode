/**
 * O(n)
 */
fun longestSquareStreak(nums: IntArray): Int {

    val visited = mutableSetOf<Int>()
    val numSet = nums.toSet()

    nums.sort()
    var ans = -1

    for (d in nums) {
        if (d in visited) continue

        visited += d

        var streak = 1
        var t = d
        while (t * t in numSet) {
            streak ++
            visited += t * t
            t *= t
        }

        if (streak >= 2) ans = maxOf(ans, streak)
    }

    return ans
}
