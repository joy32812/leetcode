/**
 * Greedy.
 */
fun minimumPartition(s: String, k: Int): Int {

    var last = 0L
    var i = 0
    var ans = 0

    while (i < s.length) {
        if (s[i] - '0' > k) return -1

        val tmp = last * 10 + (s[i] - '0')
        last = if (tmp > k) {
            ans ++
            (s[i] - '0').toLong()
        } else {
            tmp
        }

        i ++
    }

    if (last > 0) ans ++
    return ans
}

fun main() {
    // s = "165462", k = 60
    println(minimumPartition("165462", 60))
}
