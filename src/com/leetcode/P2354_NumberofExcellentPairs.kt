/**
 * Slide window.
 */
fun countExcellentPairs(nums: IntArray, k: Int): Long {

    val sort = nums.toSet().map { d -> d to d.toString(2).count { it == '1' } }.sortedBy { it.second }

    var ans = 0L
    var r = sort.size - 1

    for (i in sort.indices) {
        while (r >= i && sort[i].second + sort[r].second >= k) {
            r --
        }

        if (r < i) {
            ans ++
            r ++
        }

        ans += 2 * (sort.size - r - 1)
    }

    return ans
}


/**
 * Group by.
 */
fun countExcellentPairs2(nums: IntArray, k: Int): Long {

    val cntMap =
        nums.toSet()
            .map { d -> d.toString(2).count { it == '1' } }
            .groupBy { it }
            .mapValues { it.value.size }

    var ans = 0L
    for ((k1, v1) in cntMap) {
        for ((k2, v2) in cntMap) {
            if (k1 + k2 >= k) {
                ans += v1 * v2
            }
        }
    }

    return ans
}
