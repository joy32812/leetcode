/**
 * brute force
 */
fun checkDistances(s: String, distance: IntArray): Boolean {

    val gp = s
        .withIndex()
        .map { it.value to it.index }
        .groupBy { it.first }
        .mapValues { it.value.map { it.second } }

    return gp.all { (c, pos) -> Math.abs(pos[0] - pos[1]) - 1 == distance[c - 'a'] }

}
