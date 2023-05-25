fun punishmentNumber(n: Int): Int {

    val resultMap = mutableMapOf<String, Boolean>()

    fun wiredSame(x: Int, y: Int): Boolean {
        val key = "$x-$y"
        if (key in resultMap) return resultMap[key]!!

        val yStr = y.toString()

        var tmp = 0
        for (i in yStr.indices) {
            tmp = tmp * 10 + (yStr[i] - '0')
            if (tmp > x) break

            if (i == yStr.length - 1) {
                if (tmp == x) {
                    resultMap[key] = true
                    return true
                }
            } else {
                if (wiredSame(x - tmp, yStr.substring(i + 1).toInt())) {
                    resultMap[key] = true
                    return true
                }
            }
        }


        resultMap[key] = false
        return false
    }


    fun isFineNumber(x: Int): Boolean {
        return wiredSame(x, x * x)
    }

    return (1..n).filter { isFineNumber(it) }.map { it * it }.sum()

}

fun main() {
    println(punishmentNumber(1000))
}
