/**
 * 1. get prefix sum for string "1", "2", ..., "n"
 * 2. check if it is okay to split string in X parts.
 *  - min length: first (x - 1) part + 1
 *  - max length: first (x - 1) part + (max last part)
 */
fun splitMessage(message: String, limit: Int): Array<String> {
    val upper = message.length

    val lens = (0 .. upper).map { "$it".length }.toTypedArray()
    lens[0] = 0
    val presum = Array(upper + 1) { 0 }
    for (i in 1 .. upper) presum[i] = presum[i - 1] + lens[i]

    fun okay(x: Int): Boolean {
        val first = limit * (x - 1) - presum[x - 1] - (x - 1) * (3 + "$x".length)
        val last = limit - 3 - 2 * "$x".length

        val mi = first + 1
        val ma = first + last

        return message.length in mi .. ma
    }

    fun split(x: Int): Array<String> {
        val ans = mutableListOf<String>()

        var now = 0

        for (j in 1..x) {
            val used = limit - 3 - "$x".length - "$j".length

            val from = now
            val to = minOf(now + used, message.length)
            ans += message.substring(from, to) + "<${j}/${x}>"

            now = to
        }

        return ans.toTypedArray()
    }

    for (i in 1 .. upper) {
        if (okay(i)) return split(i)
    }

    return arrayOf()
}
