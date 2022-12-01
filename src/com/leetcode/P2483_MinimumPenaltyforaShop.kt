/**
 * O(n) one pass.
 */
fun bestClosingTime(customers: String): Int {
    val n = customers.length

    val left = Array(n) { 0 }
    val right = Array(n) { 0 }

    for (i in customers.indices) {
        left[i] = if (i == 0) 0 else left[i - 1]
        if (customers[i] == 'N') left[i]++
    }

    for (i in customers.indices.reversed()) {
        right[i] = if (i == n - 1) 0 else right[i + 1]
        if (customers[i] == 'Y') right[i]++
    }

    val pen = mutableListOf<Int>()
    pen += right[0]
    for (i in 1 .. n) {
        pen.add(left[i - 1] + if (i < n) right[i] else 0)
    }

    val mi = pen.minOrNull()!!
    return pen.indexOfFirst { it == mi }

}
