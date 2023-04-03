fun makeSubKSumEqual(arr: IntArray, k: Int): Long {

    val n = arr.size
    val fathers = IntArray(n) { -1 }

    fun getFather(x: Int): Int {
        if (fathers[x] == -1) return x
        fathers[x] = getFather(fathers[x])
        return fathers[x]
    }

    for (i in 0 until n) {
        val next = (i + k) % n

        if (next == i) continue

        val f1 = getFather(i)
        val f2 = getFather(next)

        if (f1 != f2) {
            fathers[f1] = f2
        }
    }

    val groups = mutableMapOf<Int, MutableList<Long>>()

    for (i in 0 until n) {
        val f = getFather(i)
        groups.getOrPut(f) { mutableListOf() }.add(arr[i].toLong())
    }

    var ans = 0L

    for (group in groups.values) {
        val A = group.sorted()
        val half = A[(A.size - 1) / 2]

        ans += A.map { Math.abs(it - half) }.sum()
    }

    return ans
}

fun main() {
    // arr = [1,4,1,3], k = 4
    println(makeSubKSumEqual(
        intArrayOf(1, 4, 1, 3),
        4
    ))
}
