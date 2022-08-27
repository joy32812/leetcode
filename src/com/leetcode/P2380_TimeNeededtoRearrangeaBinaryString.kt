fun secondsToRemoveOccurrences(s: String): Int {

    val chars = s.toCharArray()

    var ans = 0
    while (true) {

        var cnt = 0
        var i = chars.size  - 1
        while (i > 0) {
            if (chars[i] == '1' && chars[i - 1] == '0') {
                cnt ++
                chars[i] = '0'
                chars[i - 1] = '1'
                i --
            }

            i --
        }

        if (cnt == 0) {
            break
        }

        ans ++
    }


    return ans
}

fun main() {
    println(secondsToRemoveOccurrences("0110101"))
}
