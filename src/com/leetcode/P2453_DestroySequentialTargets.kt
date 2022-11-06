/**
 * Mod
 */
fun destroyTargets(nums: IntArray, space: Int): Int {

    val gp = nums.map { it % space }.groupBy { it }.mapValues { it.value.size }
    val max = gp.map { it.value }.maxOrNull()!!

    var ans = Int.MAX_VALUE

    for ((k, v) in gp) {
        if (v == max) {
            ans = minOf(ans, nums.filter { it % space == k }.minOrNull()!!)
        }
    }

    return ans

}
