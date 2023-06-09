/**
 * greedy.
 */
fun semiOrderedPermutation(nums: IntArray): Int {
    val n = nums.size

    val p1 = nums.indexOf(1)
    val pn = nums.indexOf(n)


    return (p1 + n - pn - 1) + if (p1 > pn) -1 else 0

}
