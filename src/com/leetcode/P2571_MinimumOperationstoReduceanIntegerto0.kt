/**
 * from back to front.
 * check last '1'
 */
fun minOperations(n: Int): Int {

    var ans = 0
    var t = n

    while (t > 0) {
        if (t % 2 == 0) {
            t = t shr 1
            continue
        }

        ans ++
        if (t and 3 == 3) {
            t ++
        }

        t = t shr 1
    }

    return ans
}

fun main() {
    println(minOperations(7862))
}
