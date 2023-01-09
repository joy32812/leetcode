/**
 * binary search.
 */
fun maxPower(stations: IntArray, range: Int, k: Int): Long {

    /**
     * Use prefix sum to get the power array.
     */
    fun getPowers(): LongArray {
        val prefixSum = LongArray(stations.size)
        prefixSum[0] = stations[0].toLong()
        for (i in 1 until stations.size) {
            prefixSum[i] = prefixSum[i - 1] + stations[i]
        }

        fun getSum(l: Int, r: Int): Long {
            if (l <= 0) return prefixSum[r]
            return prefixSum[r] - prefixSum[l - 1]
        }

        val powers = LongArray(stations.size)
        for (i in stations.indices) {
            val l = i - range
            val r = i + range
            val left = if (l < 0) 0 else l
            val right = if (r >= stations.size) stations.size - 1 else r
            powers[i] = getSum(left, right)
        }
        return powers
    }

    val powers = getPowers()

    /**
     * Greedy to check if x is ok.
     */
    fun okay(x: Long): Boolean {
        val arr = LongArray(stations.size)

        var used = 0L
        var delta = 0L
        for (i in powers.indices) {
            if (i - range - 1 >= 0) {
                delta -= arr[i - range - 1]
            }

            if (powers[i] + delta < x) {
                val addId = if (i + range >= stations.size) stations.size - 1 else i + range
                val need = x - powers[i] - delta
                arr[addId] += need
                used += need
                delta += need
            }

            if (used > k) return false
        }

        return true
    }

    var l = 0L
    var r = Long.MAX_VALUE / 5

    while (l < r) {
        val m = (l + r) / 2

        if (!okay(m)) r = m
        else l = m + 1
    }

    return l - 1

}
