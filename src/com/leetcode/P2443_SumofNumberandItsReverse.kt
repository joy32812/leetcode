/**
 * brute force.
 */
fun sumOfNumberAndReverse(num: Int): Boolean {

    return (0..num).any { it + it.toString().reversed().toInt() == num }

}
