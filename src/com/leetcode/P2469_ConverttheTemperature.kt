/**
 * Easy.
 */
fun convertTemperature(celsius: Double): DoubleArray {
    return doubleArrayOf(celsius + 273.15, celsius * 1.8 + 32)
}
