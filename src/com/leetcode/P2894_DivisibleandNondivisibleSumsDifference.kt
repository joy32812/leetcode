/**
 * easy
 */
fun differenceOfSums(n: Int, m: Int): Int {
    val num1 = (1..n).filter { it % m != 0 }.sum()
    val num2 = (1..n).filter { it % m == 0 }.sum()

    return num1 - num2
}
