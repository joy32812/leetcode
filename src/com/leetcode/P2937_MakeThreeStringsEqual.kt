fun findMinimumOperations(s1: String, s2: String, s3: String): Int {

    val totalLen = s1.length + s2.length + s3.length
    val minLen = minOf(s1.length, s2.length, s3.length)

    for (i in minLen downTo 1) {
        val s1Sub = s1.substring(0, i)
        val s2Sub = s2.substring(0, i)
        val s3Sub = s3.substring(0, i)

        if (s1Sub == s2Sub && s2Sub == s3Sub) {
            return totalLen - 3 * i
        }
    }

    return -1
}
