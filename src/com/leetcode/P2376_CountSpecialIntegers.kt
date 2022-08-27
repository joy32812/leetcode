/**
 * Count numbers.
 * Need to check leading zeros.
 */
fun countSpecialNumbers(n: Int): Int {

    fun count(len: Int, canLeadingZero: Boolean, before: Set<Int>): Int {
        if (len == 0) return 1

        val now = (0..9).toSet().minus(before)
        var size = now.size
        var ans = 1

        for (i in 1 .. len) {
            if (i == 1) {
                if (!canLeadingZero && 0 in now) {
                    ans *= size - 1
                } else {
                    ans *= size
                }
            } else {
                ans *= size
            }

            size --
        }

        return ans
    }

    val s = n.toString()

    var ans = 0

    for (i in 1 until s.length) ans += count(i, false, emptySet())

    val set = mutableSetOf<Int>()
    for (i in s.indices) {
        val from = if (i == 0) 1 else 0
        val now = s[i] - '0'

        for (j in from until now) {
            if (j in set) continue
            set.add(j)
            ans += count(s.length - i - 1, true, set)
            set.remove(j)
        }

        if (now in set) break
        set += now
    }

    if (s.toSet().size == s.length) ans ++

    return ans
}

fun main() {
    println(countSpecialNumbers(20))
    println(countSpecialNumbers(5))
    println(countSpecialNumbers(135))
    println(countSpecialNumbers(225))
}
