fun smallestBeautifulString(s: String, k: Int): String {

    val nums = s.map { it - 'a' }.reversed().toIntArray()

    fun okay(x: Int): Boolean {
        if (x - 1 >= 0 && nums[x] == nums[x - 1]) return false
        if (x - 2 >= 0 && nums[x] == nums[x - 2]) return false
        if (x + 1 < nums.size && nums[x] == nums[x + 1]) return false
        if (x + 2 < nums.size && nums[x] == nums[x + 2]) return false

        return true
    }

    for (i in nums.indices) {

        while (nums[i] < k) {
            nums[i] ++

            if (nums[i] == k) break

            if (okay(i)) {
                for (j in i - 1 downTo 0) {
                    val preSet = mutableSetOf(nums[j + 1])
                    if (j + 2 < nums.size) preSet.add(nums[j + 2])

                    nums[j] = (setOf(0, 1, 2) - preSet).minOrNull()!!
                }
                return nums.reversed().map { 'a' + it }.joinToString("")
            }
        }

    }


    return ""
}

fun main() {
    // "dc"
    // 4
    println(smallestBeautifulString("dc", 4))

    //    "abcz"
    //    26
    println(smallestBeautifulString("abcz", 26))

    // "cegaf"
    // 7
    println(smallestBeautifulString("cegaf", 7))
}
