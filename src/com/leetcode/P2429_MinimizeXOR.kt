/**
 * Greedy.
 */
fun minimizeXor(num1: Int, num2: Int): Int {

    var oneNumber = num2.toString(2).count { it == '1' }
    var ans = 0

    // mask all the ones from high to low.
    for (i in 30 downTo 0) {
        if (oneNumber == 0) break
        if (num1 and (1 shl i) == 0) continue

        ans += 1 shl i
        oneNumber--
    }

    // mask all the zeros from low to high
    for (i in 0 until 30) {
        if (oneNumber == 0) break
        if (num1 and (1 shl i) != 0) continue

        ans += 1 shl i
        oneNumber--
    }

    return ans
}
