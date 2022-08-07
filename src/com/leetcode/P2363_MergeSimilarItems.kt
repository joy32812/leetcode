/**
 * map
 */
fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>): List<List<Int>> {

    val v1 = items1.associate { it[0] to it[1] }
    val v2 = items2.associate { it[0] to it[1] }

    val keys = v1.keys.union(v2.keys)

    return keys.map { listOf(it, (v1[it] ?: 0) + (v2[it] ?: 0)) }.sortedBy { it[0] }
}
