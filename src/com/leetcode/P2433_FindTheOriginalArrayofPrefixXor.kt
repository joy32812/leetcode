/**
 * A^B=C
 * B^C=A
 * C^A=B
 */
fun findArray(pref: IntArray): IntArray {

    return pref.indices.map { i -> if (i == 0) pref[i] else pref[i] xor pref[i - 1] }.toIntArray()

}
