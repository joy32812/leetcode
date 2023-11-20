import java.math.BigInteger

fun maximumXorProduct(a: Long, b: Long, n: Int): Int {
    val mod = 1_000_000_007L

    var aa = 0L
    var bb = 0L

    var flag = -1L
    for (i in 50 downTo 0) {

        val aBit = (a shr i) and 1
        val bBit = (b shr i) and 1

        if (i >= n) {
            aa += aBit shl i
            bb += bBit shl i
            if (aa < bb) {
                flag = 1
            } else if (aa > bb) {
                flag = 0
            }
            continue
        }

        if (aBit == bBit) {
            aa += 1L shl i
            bb += 1L shl i
        } else {
            if (flag == -1L) {
                aa += 1L shl i
                flag = 0
            } else {
                aa += flag shl i
                bb += (1L - flag) shl i
            }
        }
    }

    return BigInteger.valueOf(aa).multiply(BigInteger.valueOf(bb)).mod(BigInteger.valueOf(mod)).toInt()
}
