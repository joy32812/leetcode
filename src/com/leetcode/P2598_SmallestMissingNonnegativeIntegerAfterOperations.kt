fun findSmallestInteger(nums: IntArray, value: Int): Int {

    val n = nums.size
    val map = mutableMapOf<Int, Int>()

    for (d in nums) {
        val ll = (0 - d) / value
        val rr = (n - d) / value

        for (i in ll..rr) {
            val x = d + i * value

            if (x in 0..n) {
                map[x] = (map[x] ?: 0) + 1
                break
            }
        }
    }

    for (i in 0..n) {
        if (i !in map) return i

        val cnt = (map[i] ?: 0) - 1
        map.remove(i)

        if (cnt > 0) map[i + value] = cnt
    }

    return n
}

fun main() {

//    [3,2,3,1,0,1,4,2,3,1,4,1,3]
//    5
    println(findSmallestInteger(
        intArrayOf(3, 2, 3, 1, 0, 1, 4, 2, 3, 1, 4, 1, 3),
        5
    ))

}
