
fun countDigits(num: Int): Int {
    return "$num".count { num % "$it".toInt() == 0 }
}
