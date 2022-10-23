/**
 * brute force.
 */
fun countTime(time: String): Int {

    var cnt = 0
    val (t1, t2, t3, t4) = time.toCharArray()

    fun okay(a: Int, b: Int, c: Int, d: Int): Boolean {
        if (t1 != '?' && t1 - '0' != a) return false
        if (t2 != '?' && t2 - '0' != b) return false
        if (t3 != '?' && t3 - '0' != c) return false
        if (t4 != '?' && t4 - '0' != d) return false


        val x = a * 10 + b
        val y = c * 10 + d

        return x in 0..23 && y >= 0 && y <= 59
    }

    for (i in 0 .. 9) {
        for (j in 0 .. 9) {
            for (x in 0 .. 9) {
                for (y in 0 .. 9) {

                    if(okay(i, j, x, y)) cnt ++

                }
            }
        }
    }


    return cnt
}
