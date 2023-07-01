fun makeTheIntegerZero(num1: Int, num2: Int): Int {

    fun Long.toBitCount() = this.toString(2).count { it == '1' }

    for (k in 0 .. 61) {
        val target = num1 - 1L * k * num2

        if (target >= 0 && k >= target.toBitCount() && k <= target) return k
    }

    return -1
}

fun main() {
    println(makeTheIntegerZero(3, -2))
}

