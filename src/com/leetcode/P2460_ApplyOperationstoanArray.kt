
fun applyOperations(nums: IntArray): IntArray {

    val res = nums.toMutableList()

    for (i in 0 until res.size - 1) {

        if (res[i] == res[i + 1]) {
            res[i] *= 2
            res[i + 1] = 0
        }
    }


    val aa = res.filter { it != 0 }.toMutableList()
    val bb = res.filter { it == 0 }.toMutableList()

    aa.addAll(bb)

    return aa.toIntArray()
}

fun main() {
    println(applyOperations(intArrayOf(847,847,0,0,0,399,416,416,879,879,206,206,206,272)).contentToString())
}
