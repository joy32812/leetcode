fun categorizeBox(length: Int, width: Int, height: Int, mass: Int): String {

    fun isBulky(): Boolean {
        val all = listOf(length, width, height, mass)
        val volume = 1L * length * width * height
        return all.any { it >= 10000 } || volume >= 1_000_000_000
    }

    fun isHeavy() = mass >= 100

    return when {
        isBulky() && isHeavy() -> "Both"
        isBulky() -> "Bulky"
        isHeavy() -> "Heavy"
        else -> "Neither"
    }
}
