/**
 * easy.
 */
fun equalFrequency(word: String): Boolean {

    fun okay(i: Int) =
        word.filterIndexed { index, c -> index != i }
            .groupBy { it }
            .mapValues { it.value.size }
            .values.toSet().size == 1

    return word.indices.any { okay(it) }
}
