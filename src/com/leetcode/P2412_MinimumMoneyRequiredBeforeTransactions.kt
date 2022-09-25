/**
 * greedy.
 * First get all the negative sum.
 */
fun minimumMoney(transactions: Array<IntArray>): Long {
    val negSum = transactions.map { minOf(0, it[1] - it[0]).toLong() }.sum()

    var ans = 0L
    for ((lost, gain) in transactions) {
        val diff = minOf(0, gain - lost)

        ans = maxOf(
            ans,
            Math.abs(negSum - diff - lost)
        )
    }

    return ans
}
