fun xorBeauty(nums: IntArray): Int {

    fun getForBit(x: Int): Int {

        val bitArr = nums.map { if (it and (1 shl x) != 0) 1 else 0 }.toIntArray()

        val ones = bitArr.count { it == 1 }
        val zeros = bitArr.size - ones

        var ans = 0L
        for (i in bitArr.indices) {
            if (bitArr[i] == 0) continue

            val total = 1L * bitArr.size * bitArr.size
            val zz = 1L * zeros * zeros
            val oo = total - zz

            ans += oo
        }

        return if (ans % 2 == 0L) 0 else 1
    }

    var ans = 0
    for (i in 0..30) {
        ans = ans or (getForBit(i) shl i)
    }

    return ans
}
