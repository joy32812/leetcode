/**
 * easy.
 */
fun bestHand(ranks: IntArray, suits: CharArray): String {
    if (suits.toSet().size == 1) return "Flush"

    val maxCnt = ranks.groupBy { it }.map { it.value.size }.maxOrNull()!!
    if (maxCnt >= 3) return "Three of a Kind"
    if (maxCnt == 2) return "Pair"

    return "High Card"
}

