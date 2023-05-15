fun countSeniors(details: Array<String>): Int {
    fun moreThan60(s: String) = s.substring(11..12).toInt() > 60

    return details.count(::moreThan60)
}
