private data class Seg(val l: Int, val r: Int)
fun countSubarrays(nums: IntArray, k: Int): Long {

    // get list of segments, for each segment, every (number & k) == k
    fun getSegs(): List<Seg> {
        val segs = mutableListOf<Seg>()
        var l = 0
        for (r in nums.indices) {
            if (nums[r] and k == k) continue
            if (l < r) segs.add(Seg(l, r - 1))
            l = r + 1
        }
        if (l < nums.size) segs.add(Seg(l, nums.size - 1))
        return segs
    }

    fun Seg.getCount(): Long {
        val (l, r) = this
        var size = 0
        val bitCnt = Array(32) { 0 }

        fun add(x: Int) {
            size ++
            for (i in 0 until 32) {
                if ((x and (1 shl i)) != 0) {
                    bitCnt[i]++
                }
            }
        }

        fun remove(x: Int) {
            size --
            for (i in 0 until 32) {
                if ((x and (1 shl i)) != 0) {
                    bitCnt[i]--
                }
            }
        }

        fun okay(): Boolean {
            var res = 0
            for (i in 0 until 32) {
                if (bitCnt[i] == size) {
                    res = res or (1 shl i)
                }
            }
            return res == k
        }

        var p = l - 1
        var ans = 0L
        for (i in l..r) {
            // sliding widow, find the leftmost position that okay() is true
            while (p < r && !okay()) {
                p ++
                add(nums[p])
            }

            if (!okay()) break

            ans += r - p + 1

            remove(nums[i])
        }

        return ans
    }


    return getSegs().sumOf { it.getCount() }
}

