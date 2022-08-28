/**
 * Greedy
 */
fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {

    fun getGarbage(type: Char): Int {
        var ans = 0

        var maxIndex = -1
        for (i in garbage.indices) {

            for (c in garbage[i]) {
                if (c == type) {
                    maxIndex = i
                    ans ++
                }
            }
        }

        if (maxIndex == -1) return 0

        return ans + travel.mapIndexed { i, d -> if (i < maxIndex) d else 0 }.sum()
    }



    return getGarbage('P') + getGarbage('M') + getGarbage('G')
}
