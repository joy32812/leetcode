/**
 * greedy.
 */
fun makeIntegerBeautiful(n: Long, target: Int): Long {

    fun Long.toDigitSum() = this.toString().map { it - '0' }.sum()

    var digitSum = n.toDigitSum()
    if (digitSum <= target) return 0

    val nc = n.toString().map { it - '0' }.toMutableList()
    var flag = 0

    for (i in nc.indices.reversed()) {
        val d = nc[i]
        if (d == 0) continue

        nc[i] = 0
        flag = 1

        for (j in i - 1 downTo 0) {
            val now = (nc[j] + flag) % 10
            flag = (nc[j] + flag) / 10

            nc[j] = now
        }

        if(nc.sum() + flag <= target) {
            return ("" + flag + nc.joinToString("")).toLong() - n
        }
    }

    return ("" + flag + nc.joinToString("")).toLong() - n
}
