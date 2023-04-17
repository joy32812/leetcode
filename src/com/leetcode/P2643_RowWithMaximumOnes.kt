fun rowAndMaximumOnes(mat: Array<IntArray>): IntArray {

    fun IntArray.countOfOnes() = this.count { it == 1 }

    return mat.indices
        .map { intArrayOf(it, mat[it].countOfOnes()) }
        .sortedWith(compareByDescending<IntArray> { it[1] }.thenBy { it[0] })
        .first()
}
