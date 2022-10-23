/**
 * bit manipulation.
 */
fun productQueries(n: Int, queries: Array<IntArray>): IntArray {

    val mod = 1000000007
    val powers = mutableListOf<Int>()

    for (i in 0 until 31) {
        if (n and (1 shl i) != 0) {
            powers.add(1 shl i)
        }
    }

    fun getValue(l: Int, r: Int): Int {

        var ans = 1L
        for (i in l .. r) {
            ans = (ans * powers[i]) % mod
        }

        return ans.toInt()
    }

    return queries.map { getValue(it[0], it[1]) }.toIntArray()



}
