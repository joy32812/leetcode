/**
 * bitmask
 */
fun beautifulSubarrays(nums: IntArray): Long {

    val cntMap = mutableMapOf(0 to 1)
    var ans = 0L

    val bits = Array(25) { 0 }

    for (d in nums) {
        for (i in 0..24) {
            if (d and (1 shl i) != 0) {
                bits[i] = (bits[i] + 1) % 2
            }
        }

        val mask = bits.reversed().joinToString("").toInt(2)

        ans += cntMap.getOrDefault(mask, 0)
        cntMap[mask] = cntMap.getOrDefault(mask, 0) + 1
    }

    return ans
}
