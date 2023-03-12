/**
 * easy.
 */
fun vowelStrings(words: Array<String>, left: Int, right: Int): Int {

    fun Char.isVowel() = this in "aeiou"
    fun String.isVowelString() = this.first().isVowel() && this.last().isVowel()

    return (left..right).count { words[it].isVowelString() }
}
