fun doesValidArrayExist(derived: IntArray): Boolean {
    val n = derived.size

    val bits = IntArray(n) { -1 }
    bits[0] = 0

    for (i in derived.indices) {
        val j = (i + 1) % n

        if (derived[i] == 0) {
            // same
            if (bits[j] != -1 && bits[j] != bits[i]) return false

            bits[j] = bits[i]
        } else {
            // diff
            if (bits[j] != -1 && bits[j] == bits[i]) return false

            bits[j] = 1 - bits[i]
        }
    }

    return true
}

fun main() {
    println(
        doesValidArrayExist(
            intArrayOf(
                1, 1, 1
            )
        )
    )
}
