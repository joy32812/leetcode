/**
 * DiffSet intersection.
 */
fun maximizeSquareArea(m: Int, n: Int, hFences: IntArray, vFences: IntArray): Int {

    val mod = 1_000_000_007

    fun List<Int>.toPossibleDiffs(): Set<Int> {
        val set = mutableSetOf<Int>()
        for (i in indices) {
            for (j in i + 1 until size) {
                set.add(this[j] - this[i])
            }
        }
        return set
    }

    val hDiffSet = (hFences + 1 + m).sorted().toPossibleDiffs()
    val vDiffSet = (vFences + 1 + n).sorted().toPossibleDiffs()

    hDiffSet.intersect(vDiffSet).maxOrNull()?.let { diff ->
        return (diff.toLong() * diff.toLong() % mod).toInt()
    }

    return -1
}

fun main() {
    // m = 4, n = 3, hFences = [2,3], vFences = [2]
    println(maximizeSquareArea(4, 3, intArrayOf(2, 3), intArrayOf(2)))
}
