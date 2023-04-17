fun maxDivScore(nums: IntArray, divisors: IntArray): Int {

    return divisors.toSet()
        .map { d -> d to nums.count { it % d == 0 } }
        .sortedWith(compareByDescending<Pair<Int, Int>> { it.second }.thenBy { it.first })
        .first().first

}
