fun minimumString(a: String, b: String, c: String): String {

    fun merge(x: String, y: String): String {
        val size = minOf(x.length, y.length)

        if (x in y) return y
        if (y in x) return x

        for (i in size downTo 1) {
            if (x.endsWith(y.substring(0, i))) {
                return x + y.substring(i)
            }
        }

        return x + y
    }

    fun merge(x: String, y: String, z:String) = merge(merge(x, y), z)

    return listOf(
        merge(a, b, c),
        merge(a, c, b),
        merge(b, a, c),
        merge(b, c, a),
        merge(c, a, b),
        merge(c, b, a)
    ).sortedWith(compareBy({ it.length }, { it })).first()
}
