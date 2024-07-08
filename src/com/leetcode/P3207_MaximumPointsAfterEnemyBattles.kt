// Greedy algorithm.
fun maximumPoints(enemyEnergies: IntArray, currentEnergy: Int): Long {
    val arr = enemyEnergies.map { it.toLong() }

    val min = arr.minOrNull()!!
    if (currentEnergy < min) return 0L

    val sum = arr.sum() - min + currentEnergy
    return sum / min
}
