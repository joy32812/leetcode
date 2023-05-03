fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
    val m = mat.size
    val n = mat[0].size

    val rows = Array(m) { 0 }
    val cols = Array(n) { 0 }

    val posMap = mutableMapOf<Int, Pair<Int, Int>>()

    for (i in mat.indices) {
        for (j in mat[i].indices) {
            posMap[mat[i][j]] = Pair(i, j)
        }
    }

    for (i in arr.indices) {
        val (x, y) = posMap[arr[i]]!!
        rows[x]++
        cols[y]++

        if (rows[x] == n || cols[y] == m) {
            return i
        }
    }

    return -1
}
