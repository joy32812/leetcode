/**
 * easy
 */
fun minMaxDifference(num: Int): Int {

    var max = 0
    var min = 1_000_000_000 + 7

    var ans = 0

    fun replace(i: Int, j: Int) {
        num.toString().map {
            if (it - '0' == i) "$j" else "$it"
        }.joinToString("").toInt().let {
            max = maxOf(max, it)
            min = minOf(min, it)
        }
    }

    for (i in 0 until 10) {
        for (j in 0 until 10) {
            replace(i, j)
            ans = maxOf(ans, max - min)
        }
    }

    return ans

}
