/**
 * Bitmask
 */
fun maximumRows(mat: Array<IntArray>, cols: Int): Int {
    val m = mat.size

    fun work(mask: Int): Int {
        val columnSet = mutableSetOf<Int>()
        var cnt = 0
        for (i in 0 until m) {
            if (mask and (1 shl i) == 0) continue

            cnt ++
            mat[i].forEachIndexed { j, v ->
                if (v == 1) columnSet += j
            }

            if (columnSet.size > cols) return 0
        }

        return cnt
    }

    return (1 until (1 shl m)).maxOf { work(it) }
}
