/**
 * easy.
 */
fun averageValue(nums: IntArray): Int {

    return nums.filter { it % 2 == 0 && it % 3 == 0 }.average().toInt()

}
