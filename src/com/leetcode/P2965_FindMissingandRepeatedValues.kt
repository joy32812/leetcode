/**
 * brute force
 */
fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
    val n = grid.size
    val allNums = grid.flatMap { it.toList() }
    val allNumsSet = allNums.toSet()

    val repeatedNum = allNums.find { num -> allNums.count { it == num } > 1 }!!
    val missingNum = (1..n * n).find { it !in allNumsSet }!!

    return intArrayOf(repeatedNum, missingNum)
}
