/**
 * check prime number.
 */
fun closestPrimes(left: Int, right: Int): IntArray {

    val isPrimes = BooleanArray(right + 1) { true }
    isPrimes[0] = false
    isPrimes[1] = false

    for (i in 2..right) {
        if (!isPrimes[i]) continue

        var j = i * 2
        while (j <= right) {
            isPrimes[j] = false
            j += i
        }
    }


    var num1 = -1
    var num2 = -1
    var last = -1

    for (i in left..right) {
        if (isPrimes[i]) {
            if (num1 == -1) {
                num1 = i
            } else if (num2 == -1) {
                num2 = i
            } else {
                if (i - last < num2 - num1) {
                    num1 = last
                    num2 = i
                }
            }

            last = i
        }
    }

    if (num1 == -1 || num2 == -1) return intArrayOf(-1, -1)
    return intArrayOf(num1, num2)
}
