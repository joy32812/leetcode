/**
 * greedy
 */
fun splitNum(num: Int): Int {

    val s = "$num".toCharArray().sorted().joinToString("")

    val aa = s.filterIndexed { index, c -> index % 2 == 0 }.toInt()
    val bb = s.filterIndexed { index, c -> index % 2 == 1 }.toInt()

    return aa + bb
}
