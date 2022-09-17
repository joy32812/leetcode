/**
 * brute force.
 */
fun mostFrequentEven(nums: IntArray): Int {

    val evens = nums.filter { it % 2 == 0 }
    if (evens.isEmpty()) return -1

    val counts = evens.groupingBy { it }.eachCount()
    val max = counts.map { it.value }.maxOrNull() ?: 0

    return counts.filter { it.value == max }.map { it.key }.minOrNull() ?: -1
}
