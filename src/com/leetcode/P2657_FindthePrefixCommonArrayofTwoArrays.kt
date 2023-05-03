fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {

    val setA = mutableSetOf<Int>()
    val setB = mutableSetOf<Int>()

    val ans = mutableListOf<Int>()
    var last = 0

    for (i in A.indices) {
        if (A[i] == B[i]) {
            last ++
        } else {

            if (A[i] in setB) {
                setB -= A[i]
                last ++
            } else {
                setA += A[i]
            }

            if (B[i] in setA) {
                setA -= B[i]
                last ++
            } else {
                setB += B[i]
            }
        }

        ans += last
    }

    return ans.toIntArray()
}
