/**
 * Simple math.
 */
fun numOfBurgers(a: Int, b: Int): List<Int> {

    val tmp = a - 2 * b
    if (tmp < 0 || tmp % 2 == 1) return listOf()

    val x = tmp / 2
    val y = b - x

    return if (x >= 0 && y >= 0) listOf(x, y) else listOf()
}
