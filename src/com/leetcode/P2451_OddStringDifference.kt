/**
 * easy
 */
fun oddString(words: Array<String>): String {

    fun String.toId(): String {
        return zipWithNext().map { it.second - it.first }.joinToString(",")
    }

    val mp = words.map { it.toId() }.groupBy { it }
    val res =  mp.filter { it.value.size == 1 }.keys.first()

    return words.first { it.toId() == res }
}
