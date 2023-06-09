/**
 * easy.
 */
fun removeTrailingZeros(num: String): String {

    var result = num
    while (result.endsWith('0')) {
        result = result.substring(0, result.length - 1)
    }
    return result
}
