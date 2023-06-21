fun isFascinating(n: Int): Boolean {

    val s = "$n${(n * 2)}${(n * 3)}"

    return s.length == 9 && s.toSet().size == 9 && '0' !in s

}
