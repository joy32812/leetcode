/**
 * 1. find cnt of each contiguous zeros.
 * 2. sum of it * (it + 1) / 2.
 */
fun zeroFilledSubarray(nums: IntArray): Long {

    val list = mutableListOf<Int>()
    var cnt = 0
    for (d in nums) {
        if (d != 0) {
            if (cnt > 0) list += cnt
            cnt = 0
        } else {
            cnt ++
        }
    }
    if (cnt > 0) list += cnt

    return list.map { 1L * it * (it + 1) / 2 }.sum()
}
