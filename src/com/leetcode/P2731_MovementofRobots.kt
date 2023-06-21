/**
 * pass-through.
 */
fun sumDistance(nums: IntArray, s: String, d: Int): Int {

    val positions = nums.mapIndexed { i, num ->
        if (s[i] == 'R') 0L + num + d else 0L + num - d
    }.sorted()

    val mod = 1_000_000_007
    var ans = 0L
    var sum = positions[0]

    for (i in 1 until positions.size) {
        ans = (ans + (positions[i] * i - sum) % mod) % mod
        sum = (sum + positions[i]) % mod

    }

    return ans.toInt()
}
