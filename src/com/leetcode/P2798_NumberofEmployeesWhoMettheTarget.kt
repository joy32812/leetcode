fun numberOfEmployeesWhoMetTarget(hours: IntArray, target: Int): Int {
    return hours.count { it >= target }
}
